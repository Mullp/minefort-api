package me.mullp.server;

import com.google.gson.annotations.SerializedName;
import me.mullp.icon.Icon;
import me.mullp.subuser.SubUserRole;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Date;
import java.util.List;

public class MyServer {
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
  @SerializedName("category")
  private @NotNull Category category;
  @SerializedName("subUsers")
  private @NotNull List<SubUser> subUsers;
  @SerializedName("state")
  private @NotNull ServerState state;
  @SerializedName("support")
  private @NotNull Support support;
  @SerializedName("usage")
  private @NotNull Usage usage;
  @SerializedName("backups")
  private @NotNull List<Backup> backups;
  @SerializedName("subscription")
  private @NotNull Subscription subscription;
  @SerializedName("unlockedIcons")
  private @NotNull List<Icon> unlockedIcons;
  @SerializedName("settings")
  private @NotNull Settings settings;
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

  public @NotNull Subscription getSubscription() {
    return subscription;
  }

  public @NotNull List<Icon> getUnlockedIcons() {
    return unlockedIcons;
  }

  public @NotNull Settings getSettings() {
    return settings;
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

  private static class Subscription {
    @SerializedName("currentPackageId")
    private final @NotNull Integer currentPackageId;
    @SerializedName("nextPackageId")
    private final @Nullable Integer nextPackageId;

    public Subscription(@NotNull Integer currentPackageId, @Nullable Integer nextPackageId) {
      this.currentPackageId = currentPackageId;
      this.nextPackageId = nextPackageId;
    }

    public @NotNull Integer getCurrentPackageId() {
      return currentPackageId;
    }

    public @Nullable Integer getNextPackageId() {
      return nextPackageId;
    }
  }

  private static class Settings {
    @SerializedName("lobbyVisible")
    private final @NotNull Boolean lobbyVisible;
    @SerializedName("startupCommand")
    private final @NotNull Integer startupCommand;
    @SerializedName("cosmetics")
    private final @NotNull Boolean cosmetics;

    public Settings(@NotNull Boolean lobbyVisible, @NotNull Integer startupCommand, @NotNull Boolean cosmetics) {
      this.lobbyVisible = lobbyVisible;
      this.startupCommand = startupCommand;
      this.cosmetics = cosmetics;
    }

    public @NotNull Boolean isLobbyVisible() {
      return lobbyVisible;
    }

    public @NotNull StartupCommand getStartupPermission() {
      return StartupCommand.values()[startupCommand];
    }

    public @NotNull Boolean isCosmeticsEnabled() {
      return cosmetics;
    }
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

  private static class Usage {
    @SerializedName("disk")
    private final @NotNull Integer disk;
    @SerializedName("ram")
    private final @NotNull Integer ram;

    public Usage(@NotNull Integer disk, @NotNull Integer ram) {
      this.disk = disk;
      this.ram = ram;
    }

    public @NotNull Integer getDisk() {
      return disk;
    }

    public @NotNull Integer getRam() {
      return ram;
    }
  }

  private static class Support {
    @SerializedName("offline")
    private final @NotNull Boolean offline;
    @SerializedName("bedrock")
    private final @NotNull Boolean bedrock;

    public Support(@NotNull Boolean offline, @NotNull Boolean bedrock) {
      this.offline = offline;
      this.bedrock = bedrock;
    }

    public @NotNull Boolean supportsOffline() {
      return offline;
    }

    public @NotNull Boolean supportsBedrock() {
      return bedrock;
    }
  }

  private static class SubUser {
    @SerializedName("userId")
    private final @NotNull String userId;
    @SerializedName("email")
    private final @Nullable String email;
    @SerializedName("role")
    private final @NotNull SubUserRole role;
    @SerializedName("accepted")
    private final @NotNull Boolean accepted;

    public SubUser(@NotNull String userId, @Nullable String email, @NotNull SubUserRole role, @NotNull Boolean accepted) {
      this.userId = userId;
      this.email = email;
      this.role = role;
      this.accepted = accepted;
    }

    public @NotNull String getUserId() {
      return userId;
    }

    public @Nullable String getEmail() {
      return email;
    }

    public @NotNull SubUserRole getRole() {
      return role;
    }

    public @NotNull Boolean getAccepted() {
      return accepted;
    }
  }

  private static class Backup {
    @SerializedName("backupId")
    private final @NotNull String id;
    @SerializedName("date")
    private final @NotNull Date createdAt;

    public Backup(@NotNull String id, @NotNull Date createdAt) {
      this.id = id;
      this.createdAt = createdAt;
    }

    public @NotNull String getId() {
      return id;
    }

    public @NotNull Date getCreatedAt() {
      return createdAt;
    }
  }
}
