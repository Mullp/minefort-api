package me.mullp.http;

import java.util.concurrent.CompletableFuture;

public interface MinefortHttpClient {
  String DEFAULT_USER_AGENT = "Minefort/1.0";

  String getSessionToken();

  void setSessionToken(String sessionToken);

  CompletableFuture<MinefortHttpResponse> makeGetRequest(String url);

  CompletableFuture<MinefortHttpResponse> makePostRequest(String url, String json);

  CompletableFuture<MinefortHttpResponse> makeAuthenticatedGetRequest(String url);

  CompletableFuture<MinefortHttpResponse> makeAuthenticatedPostRequest(String url, String json);

  void shutdown();
}
