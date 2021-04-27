package com.binance.api.client.domain.account;

import com.binance.api.client.constant.BinanceApiConstants;
import com.binance.api.client.domain.OrderSide;
import com.binance.api.client.domain.OrderType;
import com.binance.api.client.domain.PositionSide;
import com.binance.api.client.domain.TimeInForce;
import com.binance.api.client.domain.WorkingType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * A trade order to enter or exit a position.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FuturesNewOrder {

    /**
     * Symbol to place the order on.
     */
    private String symbol;

    /**
     * Buy/Sell order side.
     */
    private OrderSide side;

    /**
     * Type of orderSide
     */
    private PositionSide positionSide;

    /**
     * Type of order.
     */
    private OrderType type;

    /**
     * Time in force to indicate how long will the order remain active.
     */
    private TimeInForce timeInForce;

    /**
     * Quantity.
     */
    private String quantity;

    /**
     * reduceOnly.
     */
    private boolean reduceOnly;

    /**
     * Price.
     */
    private String price;

    /**
     * A unique id for the order. Automatically generated if not sent.
     */
    private String newClientOrderId;

    /**
     * Used with stop orders.
     */
    private String stopPrice;

    /**
     * Used with close position true/false used with STOP_MARKET or TAKE_PROFIT_MARKET.
     */
    private boolean closePosition;

    /**
     * Used with TRAILING_STOP_MARKET.
     */
    private String activationPrice;

    /**
     * callbackRate
     */
    private String callbackRate;

    /**
     * workingType
     */
    private WorkingType workingType;

    /**
     * priceProtect
     */
    private boolean priceProtect;

    /**
     * Set the response JSON. ACK, RESULT, or FULL; default: RESULT.
     */
    private NewOrderResponseType newOrderRespType;

    /**
     * Receiving window.
     */
    private Long recvWindow;

    /**
     * Order timestamp.
     */
    private long timestamp;

    /**
     * Creates a new order with all required parameters.
     */

    public FuturesNewOrder(String symbol, OrderSide side, OrderType type, TimeInForce timeInForce, WorkingType workingType, String quantity, String price, boolean reduceOnly) {
        this.symbol = symbol;
        this.side = side;
        this.type = type;
        this.timeInForce = timeInForce;
        this.workingType = workingType;
        this.quantity = quantity;
        this.price = price;
        this.reduceOnly = reduceOnly;
        this.newOrderRespType = NewOrderResponseType.RESULT;
        this.timestamp = System.currentTimeMillis();
        this.recvWindow = BinanceApiConstants.DEFAULT_RECEIVING_WINDOW;
    }

    public FuturesNewOrder(String symbol, OrderSide side, OrderType type, String quantity, boolean reduceOnly) {
        this.symbol = symbol;
        this.side = side;
        this.type = type;
        this.quantity = quantity;
        this.reduceOnly = reduceOnly;
        this.newOrderRespType = NewOrderResponseType.RESULT;
        this.timestamp = System.currentTimeMillis();
        this.recvWindow = BinanceApiConstants.DEFAULT_RECEIVING_WINDOW;
    }

    public FuturesNewOrder(String symbol, OrderSide side, OrderType type, TimeInForce timeInForce, String quantity, String price, boolean reduceOnly) {
        this.symbol = symbol;
        this.side = side;
        this.type = type;
        this.timeInForce = timeInForce;
        this.quantity = quantity;
        this.price = price;
        this.reduceOnly = reduceOnly;
        this.newOrderRespType = NewOrderResponseType.RESULT;
        this.timestamp = System.currentTimeMillis();
        this.recvWindow = BinanceApiConstants.DEFAULT_RECEIVING_WINDOW;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public OrderSide getSide() {
        return side;
    }

    public void setSide(OrderSide side) {
        this.side = side;
    }

    public PositionSide getPositionSide() {
        return positionSide;
    }

    public void setPositionSide(PositionSide positionSide) {
        this.positionSide = positionSide;
    }

    public OrderType getType() {
        return type;
    }

    public void setType(OrderType type) {
        this.type = type;
    }

    public TimeInForce getTimeInForce() {
        return timeInForce;
    }

    public void setTimeInForce(TimeInForce timeInForce) {
        this.timeInForce = timeInForce;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public boolean isReduceOnly() {
        return reduceOnly;
    }

    public void setReduceOnly(boolean reduceOnly) {
        this.reduceOnly = reduceOnly;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getNewClientOrderId() {
        return newClientOrderId;
    }

    public void setNewClientOrderId(String newClientOrderId) {
        this.newClientOrderId = newClientOrderId;
    }

    public String getStopPrice() {
        return stopPrice;
    }

    public void setStopPrice(String stopPrice) {
        this.stopPrice = stopPrice;
    }

    public boolean isClosePosition() {
        return closePosition;
    }

    public void setClosePosition(boolean closePosition) {
        this.closePosition = closePosition;
    }

    public String getActivationPrice() {
        return activationPrice;
    }

    public void setActivationPrice(String activationPrice) {
        this.activationPrice = activationPrice;
    }

    public String getCallbackRate() {
        return callbackRate;
    }

    public void setCallbackRate(String callbackRate) {
        this.callbackRate = callbackRate;
    }

    public WorkingType getWorkingType() {
        return workingType;
    }

    public void setWorkingType(WorkingType workingType) {
        this.workingType = workingType;
    }

    public boolean isPriceProtect() {
        return priceProtect;
    }

    public void setPriceProtect(boolean priceProtect) {
        this.priceProtect = priceProtect;
    }

    public NewOrderResponseType getNewOrderRespType() {
        return newOrderRespType;
    }

    public void setNewOrderRespType(NewOrderResponseType newOrderRespType) {
        this.newOrderRespType = newOrderRespType;
    }

    public Long getRecvWindow() {
        return recvWindow;
    }

    public void setRecvWindow(Long recvWindow) {
        this.recvWindow = recvWindow;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public static FuturesNewOrder limitLong(String symbol, TimeInForce timeInForce, String quantity, String price, boolean reduceOnly) {
        return new FuturesNewOrder(symbol, OrderSide.BUY, OrderType.LIMIT, timeInForce, quantity, price, reduceOnly);
    }

    public static FuturesNewOrder limitShort(String symbol, TimeInForce timeInForce, String quantity, String price, boolean reduceOnly) {
        return new FuturesNewOrder(symbol, OrderSide.SELL, OrderType.LIMIT, timeInForce, quantity, price, reduceOnly);
    }

    public static FuturesNewOrder MarketLong(String symbol, String quantity, boolean reduceOnly) {
        return new FuturesNewOrder(symbol, OrderSide.BUY, OrderType.MARKET, quantity, reduceOnly);
    }

    public static FuturesNewOrder MarketShort(String symbol, String quantity, boolean reduceOnly) {
        return new FuturesNewOrder(symbol, OrderSide.SELL, OrderType.MARKET, quantity, reduceOnly);
    }

    public static FuturesNewOrder stopLimitShort(String symbol, String quantity, String stopPrice, boolean reduceOnly) {
        FuturesNewOrder order = new FuturesNewOrder(symbol, OrderSide.SELL, OrderType.STOP_MARKET, quantity, reduceOnly);
        order.setStopPrice(stopPrice);
        return order;
    }

   /* public static FuturesNewOrder stopLimitLong(String symbol, String quantity, boolean reduceOnly) {
        return new FuturesNewOrder(symbol, OrderSide.SELL, OrderType.MARKET, quantity);
    }*/

}
