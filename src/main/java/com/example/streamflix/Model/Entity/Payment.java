package com.example.streamflix.Model.Entity;


import com.example.streamflix.Model.Enums.PaymentStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JoinColumn(name = "User_Id",nullable = false)
    @ManyToOne
    private User user;
    @Column(name = "Amount" , nullable = false)
    private Double amount;
    @Column(name = "Payment_method",nullable = false)
    private String paymentMethod;
    @Column(name = "TransactionId",unique = true)
    private String transactionId;
    @Column(name = "Payment_Date",nullable = false)
    private LocalDateTime paymentDate;
    @Column(name = "Payment_Status",nullable = false)
    private PaymentStatus paymentStatus;

    @PrePersist
    public void onCreate(){
        this.paymentDate=LocalDateTime.now();
    }

    public Payment() {
    }

    public Payment(User user, Long id, Double amount, String paymentMethod, String transactionId, PaymentStatus paymentStatus) {
        this.user = user;
        this.id = id;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.transactionId = transactionId;
        this.paymentStatus = paymentStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
