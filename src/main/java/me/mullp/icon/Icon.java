package me.mullp.icon;

import com.google.gson.annotations.SerializedName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.net.URL;

public class Icon {
  @SerializedName("iconId")
  private @NotNull String id;
  @SerializedName("item")
  private @NotNull String item;
  @SerializedName("name")
  private @NotNull String name;
  @SerializedName("image")
  private @NotNull URL imageUrl;
  @SerializedName("credits")
  private @Nullable Integer price;

  public Icon(@NotNull String id, @NotNull String item, @NotNull String name, @NotNull URL imageUrl, @Nullable Integer price) {
    this.id = id;
    this.item = item;
    this.name = name;
    this.imageUrl = imageUrl;
    this.price = price;
  }

  public @NotNull String getId() {
    return id;
  }

  public @NotNull String getItem() {
    return item;
  }

  public @NotNull String getName() {
    return name;
  }

  public @NotNull URL getImageUrl() {
    return imageUrl;
  }

  public @Nullable Integer getPrice() {
    return price;
  }
}
