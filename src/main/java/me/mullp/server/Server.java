package me.mullp.server;

import com.google.gson.annotations.SerializedName;
import me.mullp.icon.Icon;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Server {
  @SerializedName("serverId")
  private @NotNull String id;
  @SerializedName("serverName")
  private @NotNull String name;
  @SerializedName("serverIcon")
  private @NotNull Icon icon;
  @SerializedName("userId")
  private @NotNull String ownerId;
  @SerializedName("version")
  private @NotNull String version;
  @SerializedName("state")
  private @NotNull ServerState state;
  @SerializedName("messageOfTheDay")
  private @NotNull String motd;
  @SerializedName("players")
  private @NotNull Players players;

  public @NotNull String getId() {
    return id;
  }

  public @NotNull String getName() {
    return name;
  }

  public @NotNull Icon getIcon() {
    return icon;
  }

  public @NotNull String getOwnerId() {
    return ownerId;
  }

  public @NotNull String getSoftware() {
    return version.split("-")[0];
  }

  public @NotNull String getVersion() {
    return version.split("-")[1];
  }

  public @NotNull ServerState getState() {
    return state;
  }

  public @NotNull String getMotd() {
    return motd;
  }

  public @NotNull List<String> getOnlinePlayers() {
    return players.getList().stream().map(Player::getUuid).toList();
  }

  public @NotNull Integer getOnlinePlayersCount() {
    return players.getOnline();
  }

  public @NotNull Integer getMaxPlayers() {
    return players.getMax();
  }

  private static class Players {
    @SerializedName("online")
    private final @NotNull Integer online;
    @SerializedName("list")
    private final @NotNull List<Player> list;
    @SerializedName("max")
    private final @NotNull Integer max;

    public Players(@NotNull Integer online, @NotNull List<Player> list, @NotNull Integer max) {
      this.online = online;
      this.list = list;
      this.max = max;
    }

    public @NotNull Integer getOnline() {
      return online;
    }

    public @NotNull List<Player> getList() {
      return list;
    }

    public @NotNull Integer getMax() {
      return max;
    }
  }

  private static class Player {
    @SerializedName("uuid")
    private final @NotNull String uuid;

    public Player(@NotNull String uuid) {
      this.uuid = uuid;
    }

    public @NotNull String getUuid() {
      return uuid;
    }
  }
}
