package com.example.streamflix.Service.Payment;

import com.example.streamflix.Model.DTO.PaymentDto;

import java.util.List;

public interface PaymentService {

    PaymentDto processPayment (PaymentDto paymentDto);
    PaymentDto getPaymentByTransactionId (String transactionId);
    List<PaymentDto> getAllPayments ();
}
