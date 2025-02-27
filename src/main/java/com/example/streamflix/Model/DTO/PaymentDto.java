package com.example.streamflix.Model.DTO;

import com.example.streamflix.Model.Entity.User;
import com.example.streamflix.Model.Enums.PaymentStatus;

import java.time.LocalDateTime;

public class PaymentDto {

    private Long id;
    private Long userId;
    private Double amount;
    private String paymentMethod;
    private String transactionId;
    private LocalDateTime paymentDate;
    private PaymentStatus paymentStatus;

    public PaymentDto() {
    }

    public PaymentDto(Long id, PaymentStatus paymentStatus, String transactionId, String paymentMethod, Double amount, Long userId) {
        this.id = id;
        this.paymentStatus = paymentStatus;
        this.transactionId = transactionId;
        this.paymentMethod = paymentMethod;
        this.amount = amount;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
