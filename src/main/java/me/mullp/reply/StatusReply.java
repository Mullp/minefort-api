package me.mullp.reply;

import com.google.gson.annotations.SerializedName;
import org.jetbrains.annotations.NotNull;

public enum StatusReply {
  @SerializedName("OK")
  OK("OK"),

  @SerializedName("NOT_AUTHENTICATED")
  NOT_AUTHENTICATED("NOT_AUTHENTICATED"),

  @SerializedName("INVALID_STATE")
  INVALID_STATE("INVALID_STATE"),

  @SerializedName("INSUFFICIENT_BALANCE")
  INSUFFICIENT_BALANCE("INSUFFICIENT_BALANCE"),

  @SerializedName("ITEM_NOT_FOUND")
  ITEM_NOT_FOUND("ITEM_NOT_FOUND"),

  @SerializedName("INVALID_INPUT")
  INVALID_INPUT("INVALID_INPUT"),

  @SerializedName("INVALID_CREDENTIALS")
  INVALID_CREDENTIALS("INVALID_CREDENTIALS"),

  @SerializedName("SERVER_NAME_ALREADY_IN_USE")
  SERVER_NAME_ALREADY_IN_USE("SERVER_NAME_ALREADY_IN_USE"),

  @SerializedName("INTERNAL_ERROR")
  INTERNAL_ERROR("INTERNAL_ERROR"),

  @SerializedName("SERVER_ACCOUNT_LIMIT")
  SERVER_ACCOUNT_LIMIT("SERVER_ACCOUNT_LIMIT"),

  @SerializedName("NO_PERMISSION")
  NO_PERMISSION("NO_PERMISSION"),

  @SerializedName("ENDPOINT_NOT_FOUND")
  ENDPOINT_NOT_FOUND("ENDPOINT_NOT_FOUND");

  private final @NotNull String status;

  StatusReply(@NotNull String name) {
    this.status = name;
  }

  public @NotNull String getStatus() {
    return status;
  }
}
