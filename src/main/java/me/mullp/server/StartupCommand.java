package me.mullp.server;

import com.google.gson.annotations.SerializedName;

public enum StartupCommand {
  /**
   * Server can only be started with "/start [name]" if it's in sleeping state.
   */
  @SerializedName("0")
  ONLY_FROM_HIBERNATION(0),
  /**
   * Server can always be started with "/start [name]", even if it's in offline state.
   */
  @SerializedName("1")
  ALWAYS(1),
  /**
   * Server cannot be started from the lobby under any circumstance.
   */
  @SerializedName("2")
  DISABLED(2);

  private final int value;

  StartupCommand(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }
}
