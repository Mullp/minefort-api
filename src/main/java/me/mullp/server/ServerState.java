package me.mullp.server;

import com.google.gson.annotations.SerializedName;

public enum ServerState {
  @SerializedName("0")
  SERVICE_OFFLINE(0),
  @SerializedName("1")
  UPLOADING(1),
  @SerializedName("2")
  DOWNLOADING(2),
  @SerializedName("3")
  STARTING(3),
  @SerializedName("4")
  ONLINE(4),
  @SerializedName("5")
  OFFLINE(5),
  @SerializedName("6")
  CREATING_BACKUP(6),
  @SerializedName("7")
  RESTORING_BACKUP(7),
  @SerializedName("8")
  STOPPING(8);

  private final int value;

  ServerState(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }
}
