package me.mullp.exceptions;

public class BadStatusException extends MinefortApiException {
  public BadStatusException(String message) {
    super(message);
  }
}
