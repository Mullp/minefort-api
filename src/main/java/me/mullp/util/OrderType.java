package me.mullp.util;

public enum OrderType {
  ASCENDING("asc"),
  DESCENDING("desc");

  /**
   * The order type.
   */
  private final String order;

  OrderType(String order) {
    this.order = order;
  }

  public String getOrder() {
    return order;
  }
}
