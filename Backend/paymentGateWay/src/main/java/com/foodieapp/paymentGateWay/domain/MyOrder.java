package com.foodieapp.paymentGateWay.domain;

import javax.persistence.*;

@Entity
public class MyOrder {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long myOrderId;
    private String orderId;
    private String amount;
    private String receipt;
    private String status;
    private String paymentId;


    public MyOrder() {
    }

    public MyOrder(Long myOrderId, String orderId, String amount, String receipt,
                   String status, String paymentId) {
        this.myOrderId = myOrderId;
        this.orderId = orderId;
        this.amount = amount;
        this.receipt = receipt;
        this.status = status;
        this.paymentId = paymentId;
    }

    public Long getMyOrderId() {
        return myOrderId;
    }

    public void setMyOrderId(Long myOrderId) {
        this.myOrderId = myOrderId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getReceipt() {
        return receipt;
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }


    @Override
    public String toString() {
        return "MyOrder{" +
                "myOrderId=" + myOrderId +
                ", orderId='" + orderId + '\'' +
                ", amount='" + amount + '\'' +
                ", receipt='" + receipt + '\'' +
                ", status='" + status + '\'' +
                ", paymentId='" + paymentId + '\'' +
                '}';
    }
}