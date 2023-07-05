package me.mullp.http;

import org.apache.http.Header;
import org.jetbrains.annotations.NotNull;

public class MinefortHttpResponse {
  private final int statusCode;
  private final @NotNull String body;
  private final @NotNull Header[] headers;

  public MinefortHttpResponse(int statusCode, @NotNull String body, @NotNull Header[] headers) {
    this.statusCode = statusCode;
    this.body = body;
    this.headers = headers;
  }

  public int getStatusCode() {
    return statusCode;
  }

  public @NotNull String getBody() {
    return this.body;
  }

  public @NotNull Header[] getHeaders() {
    return headers;
  }
}
