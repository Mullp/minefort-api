package me.mullp.reply.error;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MinefortApiError {
  @SerializedName("body")
  private List<ErrorBody> body;

  public List<ErrorBody> getBody() {
    return body;
  }
}
