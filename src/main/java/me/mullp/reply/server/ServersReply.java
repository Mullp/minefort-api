package me.mullp.reply.server;

import com.google.gson.annotations.SerializedName;
import me.mullp.reply.AbstractReply;
import me.mullp.server.Server;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ServersReply extends AbstractReply {
  @SerializedName("result")
  private @NotNull List<Server> servers;

  public @NotNull List<Server> getServers() {
    return servers;
  }
}
