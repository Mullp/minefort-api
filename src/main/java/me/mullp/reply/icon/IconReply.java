package me.mullp.reply.icon;

import com.google.gson.annotations.SerializedName;
import me.mullp.icon.Icon;
import me.mullp.reply.AbstractReply;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class IconReply extends AbstractReply {
  @SerializedName("result")
  private @NotNull List<Icon> icons;

  public @NotNull List<Icon> getIcons() {
    return icons;
  }
}
