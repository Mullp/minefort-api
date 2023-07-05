package me.mullp.exceptions;

public abstract class MinefortApiException extends RuntimeException {
  protected MinefortApiException(String message) {
    super(message);
  }
}
