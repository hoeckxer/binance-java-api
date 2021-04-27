package com.binance.api.client.impl;

import com.binance.api.client.BinanceApiAsyncFuturesRestClient;
import com.binance.api.client.BinanceApiCallback;
import com.binance.api.client.constant.BinanceApiConstants;
import com.binance.api.client.domain.account.FuturesAccount;
import com.binance.api.client.domain.account.FuturesNewOrder;
import com.binance.api.client.domain.account.FuturesNewOrderResponse;
import com.binance.api.client.domain.account.Order;
import com.binance.api.client.domain.account.request.CancelOrderRequest;
import com.binance.api.client.domain.account.request.CancelOrderResponse;
import com.binance.api.client.domain.account.request.OrderRequest;
import com.binance.api.client.domain.account.request.OrderStatusRequest;

import java.util.List;

/**
 * Implementation of Binance's Margin REST API using Retrofit with asynchronous/non-blocking method calls.
 *
 * @author Mahdi Sheikh Hosseini
 */
public class BinanceApiAsyncFuturesRestClientImpl implements BinanceApiAsyncFuturesRestClient {

    private final BinanceFuturesApiService binanceFuturesApiService;

    public BinanceApiAsyncFuturesRestClientImpl(String apiKey, String secret) {
        binanceFuturesApiService = BinanceApiServiceGenerator.createService(BinanceFuturesApiService.class, apiKey, secret);
    }

    // Margin Account endpoints

    @Override
    public void getAccount(Long recvWindow, Long timestamp, BinanceApiCallback<FuturesAccount> callback) {
        binanceFuturesApiService.getAccount(recvWindow, timestamp).enqueue(new BinanceApiCallbackAdapter<>(callback));
    }

    @Override
    public void getAccount(BinanceApiCallback<FuturesAccount> callback) {
        long timestamp = System.currentTimeMillis();
        binanceFuturesApiService.getAccount(BinanceApiConstants.DEFAULT_MARGIN_RECEIVING_WINDOW, timestamp).enqueue(new BinanceApiCallbackAdapter<>(callback));
    }

    @Override
    public void getOpenOrders(OrderRequest orderRequest, BinanceApiCallback<List<Order>> callback) {
        binanceFuturesApiService.getOpenOrders(orderRequest.getSymbol(), orderRequest.getRecvWindow(),
                orderRequest.getTimestamp()).enqueue(new BinanceApiCallbackAdapter<>(callback));
    }

    @Override
    public void newOrder(FuturesNewOrder order, BinanceApiCallback<FuturesNewOrderResponse> callback) {
        binanceFuturesApiService.newOrder(order.getSymbol(), order.getSide(), order.getPositionSide(),
                order.getType(), order.getTimeInForce(), order.getQuantity(), order.getPrice(), order.getNewClientOrderId(),
                order.getStopPrice(), order.isClosePosition(), order.getActivationPrice(), order.getWorkingType(),
                order.getNewOrderRespType(), order.getRecvWindow(), order.getTimestamp())
                .enqueue(new BinanceApiCallbackAdapter<>(callback));
    }

    @Override
    public void cancelOrder(CancelOrderRequest cancelOrderRequest, BinanceApiCallback<CancelOrderResponse> callback) {
        binanceFuturesApiService.cancelOrder(cancelOrderRequest.getSymbol(),
                cancelOrderRequest.getOrderId(), cancelOrderRequest.getOrigClientOrderId(), cancelOrderRequest.getNewClientOrderId(),
                cancelOrderRequest.getRecvWindow(), cancelOrderRequest.getTimestamp()).enqueue(new BinanceApiCallbackAdapter<>(callback));
    }

    @Override
    public void getOrderStatus(OrderStatusRequest orderStatusRequest, BinanceApiCallback<Order> callback) {
        binanceFuturesApiService.getOrderStatus(orderStatusRequest.getSymbol(),
                orderStatusRequest.getOrderId(), orderStatusRequest.getOrigClientOrderId(),
                orderStatusRequest.getRecvWindow(), orderStatusRequest.getTimestamp()).enqueue(new BinanceApiCallbackAdapter<>(callback));
    }
}
