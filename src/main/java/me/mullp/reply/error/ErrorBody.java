package me.mullp.reply.error;

import java.util.Arrays;

public class ErrorBody {
  private String message;
  private String[] path;
  private String type;
  private ErrorContext context;

  public String getMessage() {
    return message;
  }

  public String[] getPath() {
    return path;
  }

  public String getType() {
    return type;
  }

  public ErrorContext getContext() {
    return context;
  }
}
