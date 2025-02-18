package com.binance.api.client.impl;

import com.binance.api.client.BinanceApiFuturesRestClient;
import com.binance.api.client.constant.BinanceApiConstants;
import com.binance.api.client.domain.account.FuturesAccount;
import com.binance.api.client.domain.account.FuturesNewOrder;
import com.binance.api.client.domain.account.FuturesNewOrderResponse;
import com.binance.api.client.domain.account.LeverageRequest;
import com.binance.api.client.domain.account.LeverageResponse;
import com.binance.api.client.domain.account.MarginTypeRequest;
import com.binance.api.client.domain.account.Order;
import com.binance.api.client.domain.account.TradeHistoryItem;
import com.binance.api.client.domain.account.request.CancelOrderRequest;
import com.binance.api.client.domain.account.request.CancelOrderResponse;
import com.binance.api.client.domain.account.request.OrderRequest;
import com.binance.api.client.domain.account.request.OrderStatusRequest;
import com.binance.api.client.domain.general.ExchangeInfo;
import com.binance.api.client.domain.market.AggTrade;
import com.binance.api.client.domain.market.Candlestick;
import com.binance.api.client.domain.market.CandlestickInterval;
import com.binance.api.client.domain.market.OrderBook;
import com.binance.api.client.domain.market.TickerPrice;
import com.binance.api.client.domain.market.TickerStatistics;

import java.util.List;

import static com.binance.api.client.impl.BinanceApiServiceGenerator.executeSync;

/**
 * Implementation of Binance's Margin REST API using Retrofit with asynchronous/non-blocking method calls.
 */
public class BinanceApiFuturesRestClientImpl implements BinanceApiFuturesRestClient {

    private final BinanceFuturesApiService binanceApiService;

    public BinanceApiFuturesRestClientImpl(String apiKey, String secret) {
        binanceApiService = BinanceApiServiceGenerator.createService(BinanceFuturesApiService.class, apiKey, secret);
    }

    @Override
    public void ping() {
        executeSync(binanceApiService.ping());
    }

    @Override
    public Long getServerTime() {
        return executeSync(binanceApiService.getServerTime()).getServerTime();
    }

    @Override
    public ExchangeInfo getExchangeInfo() {
        return executeSync(binanceApiService.getExchangeInfo());
    }

    @Override
    public FuturesAccount getAccount() {
        long timestamp = System.currentTimeMillis();
        return executeSync(binanceApiService.getAccount(BinanceApiConstants.DEFAULT_RECEIVING_WINDOW, timestamp));
    }

    @Override
    public List<Order> getOpenOrders(OrderRequest orderRequest) {
        return executeSync(binanceApiService.getOpenOrders(orderRequest.getSymbol(), orderRequest.getRecvWindow(),
                orderRequest.getTimestamp()));
    }

    @Override
    public FuturesNewOrderResponse newOrder(FuturesNewOrder order) {
        return executeSync(binanceApiService.newOrder(order.getSymbol(), order.getSide(), order.getPositionSide(),
                order.getType(), order.getTimeInForce(), order.getQuantity(), order.getPrice(), order.getNewClientOrderId(),
                order.getStopPrice(), order.isClosePosition(), order.getActivationPrice(), order.getWorkingType(),
                order.getNewOrderRespType(), order.getRecvWindow(), order.getTimestamp()));
    }

    @Override
    public LeverageResponse changeInitialLeverage(LeverageRequest leverageRequest) {
        return executeSync(binanceApiService.changeInitialLeverage(leverageRequest.getSymbol(),
                leverageRequest.getLeverage(),
                leverageRequest.getRecvWindow(),
                leverageRequest.getTimestamp()));
    }

    @Override
    public void changeMarginType(MarginTypeRequest marginTypeRequest) {
        executeSync(binanceApiService.changeMarginType(marginTypeRequest.getSymbol(),
                marginTypeRequest.getMarginType(),
                marginTypeRequest.getRecvWindow(),
                marginTypeRequest.getTimestamp()));
    }

    @Override
    public CancelOrderResponse cancelOrder(CancelOrderRequest cancelOrderRequest) {
        return executeSync(binanceApiService.cancelOrder(cancelOrderRequest.getSymbol(),
                cancelOrderRequest.getOrderId(), cancelOrderRequest.getOrigClientOrderId(), cancelOrderRequest.getNewClientOrderId(),
                cancelOrderRequest.getRecvWindow(), cancelOrderRequest.getTimestamp()));
    }

    @Override
    public Order getOrderStatus(OrderStatusRequest orderStatusRequest) {
        return executeSync(binanceApiService.getOrderStatus(orderStatusRequest.getSymbol(),
                orderStatusRequest.getOrderId(), orderStatusRequest.getOrigClientOrderId(),
                orderStatusRequest.getRecvWindow(), orderStatusRequest.getTimestamp()));
    }

    @Override
    public String startUserDataStream() {
        return executeSync(binanceApiService.startUserDataStream()).toString();
    }

    @Override
    public void keepAliveUserDataStream(String listenKey) {
        executeSync(binanceApiService.keepAliveUserDataStream(listenKey));
    }

    @Override
    public void closeUserDataStream(String listenKey) {
        executeSync(binanceApiService.closeAliveUserDataStream(listenKey));
    }

    @Override
    public OrderBook getOrderBook(String symbol, Integer limit) {
        return executeSync(binanceApiService.getOrderBook(symbol, limit));
    }

    @Override
    public List<TradeHistoryItem> getTrades(String symbol, Integer limit) {
        return executeSync(binanceApiService.getTrades(symbol, limit));
    }

    @Override
    public List<TradeHistoryItem> getHistoricalTrades(String symbol, Integer limit, Long fromId) {
        return executeSync(binanceApiService.getHistoricalTrades(symbol, limit, fromId));
    }

    @Override
    public List<AggTrade> getAggTrades(String symbol, String fromId, Integer limit, Long startTime, Long endTime) {
        return executeSync(binanceApiService.getAggTrades(symbol, fromId, limit, startTime, endTime));
    }

    @Override
    public List<AggTrade> getAggTrades(String symbol) {
        return executeSync(binanceApiService.getAggTrades(symbol, null, null, null, null));
    }

    @Override
    public List<Candlestick> getCandlestickBars(String symbol, CandlestickInterval interval, Integer limit, Long startTime, Long endTime) {
        return executeSync(binanceApiService.getCandlestickBars(symbol, interval.getIntervalId(), limit, startTime, endTime));
    }

    @Override
    public List<Candlestick> getCandlestickBars(String symbol, CandlestickInterval interval) {
        return getCandlestickBars(symbol, interval, null, null, null);
    }

    @Override
    public List<Candlestick> getCandlestickBars(String symbol, CandlestickInterval interval, Integer limit) {
        return getCandlestickBars(symbol, interval, limit, null, null);
    }

    @Override
    public TickerStatistics get24HrPriceStatistics(String symbol) {
        return executeSync(binanceApiService.get24HrPriceStatistics(symbol));
    }

    @Override
    public List<TickerStatistics> getAll24HrPriceStatistics() {
        return executeSync(binanceApiService.getAll24HrPriceStatistics());
    }

    @Override
    public TickerPrice getPrice(String symbol) {
        return executeSync(binanceApiService.getLatestPrice(symbol));
    }
}