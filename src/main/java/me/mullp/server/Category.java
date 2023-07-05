package me.mullp.server;

import com.google.gson.annotations.SerializedName;
import org.jetbrains.annotations.NotNull;

public enum Category {
  @SerializedName("DEFAULT")
  DEFAULT("DEFAULT"),
  @SerializedName("SKYBLOCK")
  SKYBLOCK("SKYBLOCK"),
  @SerializedName("SURVIVAL")
  SURVIVAL("SURVIVAL"),
  @SerializedName("CREATIVE")
  CREATIVE("CREATIVE"),
  @SerializedName("GENS")
  GENS("GENS"),
  @SerializedName("PRISON")
  PRISON("PRISON"),
  @SerializedName("PVP")
  PVP("PVP"),
  @SerializedName("ADVENTURE")
  ADVENTURE("ADVENTURE");

  private final @NotNull String name;

  Category(@NotNull String name) {
    this.name = name;
  }

  public @NotNull String getName() {
    return name;
  }
}
