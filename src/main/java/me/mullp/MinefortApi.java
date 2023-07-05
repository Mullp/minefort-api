package me.mullp;

import com.google.gson.JsonObject;
import me.mullp.exceptions.BadStatusException;
import me.mullp.http.ApacheHttpClient;
import me.mullp.http.MinefortHttpClient;
import me.mullp.http.MinefortHttpResponse;
import me.mullp.icon.IconManager;
import me.mullp.reply.StatusReply;
import me.mullp.server.ServerManager;
import me.mullp.util.Utilities;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

public class MinefortApi {
  public static final @NotNull String BASE_URL = "https://api.minefort.com/v1/";
  private final @NotNull MinefortHttpClient httpClient = new ApacheHttpClient();

  private final @NotNull ServerManager serverManager = new ServerManager(this);
  private final @NotNull IconManager iconManager = new IconManager(this);

  public MinefortApi() {
  }

  public @NotNull MinefortHttpClient getHttpClient() {
    return this.httpClient;
  }

  public @NotNull ServerManager getServerManager() {
    return this.serverManager;
  }

  public @NotNull IconManager getIconManager() {
    return this.iconManager;
  }

  public void shutdown() {
    this.httpClient.shutdown();
  }

  public CompletableFuture<String> authenticate(@NotNull String email, @NotNull String password) {
    String json = "{\"emailAddress\":\"" +
        email +
        "\",\"password\":\"" +
        password +
        "\"}";
    return this.getHttpClient().makePostRequest(MinefortApi.BASE_URL + "auth/login", json)
        .thenApply(this::checkResponse)
        .thenApply(response -> Arrays.stream(response.getHeaders()).filter(header -> header.getName().equals("set-cookie")).findFirst().orElseThrow().getValue().split(";")[0])
        .thenApply(sessionToken -> {
          this.httpClient.setSessionToken(sessionToken);
          return sessionToken;
        });
  }

  public MinefortHttpResponse checkResponse(MinefortHttpResponse response) {
    StatusReply status = StatusReply.valueOf(Utilities.GSON.fromJson(response.getBody(), JsonObject.class).get("status").getAsString());
    switch (status) {
      case OK -> {
        return response;
      }
      case INVALID_INPUT -> throw new BadStatusException("Invalid input");
      case ENDPOINT_NOT_FOUND -> throw new BadStatusException("Endpoint not found");
      case INSUFFICIENT_BALANCE -> throw new BadStatusException("Insufficient balance");
      case INTERNAL_ERROR -> throw new BadStatusException("Internal error");
      case INVALID_CREDENTIALS -> throw new BadStatusException("Invalid credentials");
      case INVALID_STATE -> throw new BadStatusException("Invalid state");
      case ITEM_NOT_FOUND -> throw new BadStatusException("Item not found");
      case NO_PERMISSION -> throw new BadStatusException("No permission");
      case NOT_AUTHENTICATED -> throw new BadStatusException("Not authenticated");
      case SERVER_ACCOUNT_LIMIT -> throw new BadStatusException("Server account limit");
      case SERVER_NAME_ALREADY_IN_USE -> throw new BadStatusException("Server name already in use");
      default -> throw new BadStatusException("Unknown status");
    }
  }
}