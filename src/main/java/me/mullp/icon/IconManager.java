package me.mullp.icon;

import me.mullp.MinefortApi;
import me.mullp.reply.icon.IconReply;
import me.mullp.util.Utilities;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class IconManager {
  private final @NotNull MinefortApi minefortApi;

  public IconManager(@NotNull MinefortApi minefortApi) {
    this.minefortApi = minefortApi;
  }

  /**
   * Get a list of all icons available for purchase
   * @return - A list of icons
   */
  public @NotNull CompletableFuture<List<Icon>> getIcons() {
    return this.minefortApi.getHttpClient().makeAuthenticatedGetRequest(MinefortApi.BASE_URL + "server/icons")
        .thenApply(this.minefortApi::checkResponse)
        .thenApply(minefortHttpResponse -> Utilities.GSON.fromJson(minefortHttpResponse.getBody(), IconReply.class).getIcons());
  }
}
