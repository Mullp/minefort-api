package me.mullp.reply.server;

import com.google.gson.annotations.SerializedName;
import me.mullp.reply.AbstractReply;
import org.jetbrains.annotations.NotNull;

public class NameAvailableReply extends AbstractReply {
  @SerializedName("result")
  private @NotNull Boolean available;

  public @NotNull Boolean isAvailable() {
    return available;
  }
}
