package me.mullp.reply.error;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

public class ErrorContext {
  @SerializedName("limit")
  private Object limit;
  @SerializedName("valids")
  private String[] valids;
  @SerializedName("value")
  private Object value;
  @SerializedName("label")
  private String label;
  @SerializedName("key")
  private String key;

  public Object getLimit() {
    return limit;
  }

  public String[] getValids() {
    return valids;
  }

  public Object getValue() {
    return value;
  }

  public String getLabel() {
    return label;
  }

  public String getKey() {
    return key;
  }
}
