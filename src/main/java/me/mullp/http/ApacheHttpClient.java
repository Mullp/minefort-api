package me.mullp.http;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ApacheHttpClient implements MinefortHttpClient {
  private final @NotNull ExecutorService executorService;
  private final @NotNull HttpClient httpClient;
  private @Nullable String sessionToken;

  public ApacheHttpClient(@Nullable String sessionToken) {
    this.executorService = Executors.newCachedThreadPool();
    this.httpClient = HttpClientBuilder.create().disableCookieManagement().setUserAgent(DEFAULT_USER_AGENT).build();
    this.sessionToken = sessionToken;
  }

  public ApacheHttpClient() {
    this(null);
  }

  public @Nullable String getSessionToken() {
    return this.sessionToken;
  }

  public void setSessionToken(@Nullable String sessionToken) {
    this.sessionToken = sessionToken;
  }

  @Override
  public CompletableFuture<MinefortHttpResponse> makeGetRequest(String url) {
    return CompletableFuture.supplyAsync(() -> {
      try {
        HttpResponse response = this.httpClient.execute(new HttpPost(url));
        return new MinefortHttpResponse(response.getStatusLine().getStatusCode(), EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8), response.getAllHeaders());
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }, this.executorService);
  }

  @Override
  public CompletableFuture<MinefortHttpResponse> makePostRequest(String url, String json) {
    return CompletableFuture.supplyAsync(() -> {
      try {
        HttpPost request = new HttpPost(url);
        StringEntity stringEntity = new StringEntity(json);
        request.setEntity(stringEntity);
        request.setHeader("Content-type", "application/json");
        HttpResponse response = this.httpClient.execute(request);

        return new MinefortHttpResponse(response.getStatusLine().getStatusCode(), EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8), response.getAllHeaders());
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }, this.executorService);
  }

  @Override
  public CompletableFuture<MinefortHttpResponse> makeAuthenticatedGetRequest(String url) {
    return CompletableFuture.supplyAsync(() -> {
      try {
        HttpGet request = new HttpGet(url);
        request.setHeader("Cookie", this.getSessionToken());
        HttpResponse response = this.httpClient.execute(request);
        return new MinefortHttpResponse(response.getStatusLine().getStatusCode(), EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8), response.getAllHeaders());
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }, this.executorService);
  }

  @Override
  public CompletableFuture<MinefortHttpResponse> makeAuthenticatedPostRequest(String url, String json) {
    return null;
  }

  @Override
  public void shutdown() {
    this.executorService.shutdown();
  }
}
