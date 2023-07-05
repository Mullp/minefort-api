package me.mullp.reply;

import com.google.gson.annotations.SerializedName;
import me.mullp.reply.error.MinefortApiError;

public abstract class AbstractReply {
  @SerializedName("time")
  protected int time;
  @SerializedName("status")
  protected StatusReply status;
  @SerializedName("error")
  protected MinefortApiError error;

  public int getTime() {
    return time;
  }

  public StatusReply getStatus() {
    return status;
  }

  public MinefortApiError getError() {
    return error;
  }
}
