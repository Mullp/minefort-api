package me.mullp.server;

import me.mullp.MinefortApi;
import me.mullp.reply.server.MyServersReply;
import me.mullp.reply.server.ServersReply;
import me.mullp.util.OrderType;
import me.mullp.util.Utilities;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ServerManager {
  private final @NotNull MinefortApi minefortApi;

  public ServerManager(@NotNull MinefortApi minefortApi) {
    this.minefortApi = minefortApi;
  }

  /**
   * Get a list of online servers
   * @return - A list of servers
   */
  public @NotNull CompletableFuture<List<Server>> getOnlineServers() {
    return this.getOnlineServers(500, 0, OrderType.DESCENDING);
  }

  /**
   * Get a list of online servers
   * @param limit - The maximum amount of servers to return
   * @param skip - The amount of servers to skip
   * @param order - The order to sort the servers by
   * @return - A list of servers
   */
  public @NotNull CompletableFuture<List<Server>> getOnlineServers(int limit, int skip, @NotNull OrderType order) {
    String json = "{\"pagination\":{\"skip\":" +
        skip +
        ",\"limit\":" +
        limit +
        "},\"sort\":{\"field\":\"players.online\",\"order\":\"" +
        order.getOrder().toLowerCase() +
        "\"}}";
    return this.minefortApi.getHttpClient().makePostRequest(MinefortApi.BASE_URL + "servers/list", json)
        .thenApply(this.minefortApi::checkResponse)
        .thenApply(response -> Utilities.GSON.fromJson(response.getBody(), ServersReply.class).getServers());
  }

  /**
   * Get a list of all servers that the user owns
   * @return - A list of servers
   */
  public @NotNull CompletableFuture<List<MyServer>> getMyServers() {
    return this.minefortApi.getHttpClient().makeAuthenticatedGetRequest(MinefortApi.BASE_URL + "user/servers")
        .thenApply(this.minefortApi::checkResponse)
        .thenApply(response -> Utilities.GSON.fromJson(response.getBody(), MyServersReply.class).getServers());
  }
}
