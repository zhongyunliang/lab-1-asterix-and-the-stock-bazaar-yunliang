// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: service.proto

package io.grpc.stock;

public interface TradeRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:stock.TradeRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string stock_name = 1;</code>
   * @return The stockName.
   */
  java.lang.String getStockName();
  /**
   * <code>string stock_name = 1;</code>
   * @return The bytes for stockName.
   */
  com.google.protobuf.ByteString
      getStockNameBytes();

  /**
   * <code>int32 trade_volume = 2;</code>
   * @return The tradeVolume.
   */
  int getTradeVolume();

  /**
   * <code>bool is_buy = 3;</code>
   * @return The isBuy.
   */
  boolean getIsBuy();
}