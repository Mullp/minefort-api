package me.mullp.subuser;

import com.google.gson.annotations.SerializedName;

public enum SubUserRole {
  @SerializedName("0")
  VIEWER(0),
  @SerializedName("1")
  MODERATOR(1),
  @SerializedName("2")
  ADMINISTRATOR(2),
  @SerializedName("3")
  OWNER(3);

  private final int value;

  SubUserRole(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }
}
