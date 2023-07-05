package me.mullp.reply.server;

import com.google.gson.annotations.SerializedName;
import me.mullp.reply.AbstractReply;
import me.mullp.server.MyServer;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MyServersReply extends AbstractReply {
  @SerializedName("result")
  private @NotNull List<MyServer> servers;

  public @NotNull List<MyServer> getServers() {
    return servers;
  }
}
