package com.example.streamflix.Controller;


import com.example.streamflix.Model.DTO.PaymentDto;
import com.example.streamflix.Service.Payment.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {
    private final PaymentService paymentService;
    public PaymentController(PaymentService paymentService){
        this.paymentService=paymentService;
    }

    @PostMapping("/add")
    public ResponseEntity<PaymentDto> ProcessPayment(@RequestBody PaymentDto paymentDto){
        PaymentDto savedPayment = paymentService.processPayment(paymentDto);
        return new ResponseEntity<>(savedPayment, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> GetPaymentByTransactionId (@PathVariable String transactionId){
        PaymentDto received = paymentService.getPaymentByTransactionId(transactionId);
        return new ResponseEntity<>(received,HttpStatus.FOUND);
    }

    @GetMapping("/all")
    public ResponseEntity<List<?>> GetAll(){
        List<PaymentDto> all = paymentService.getAllPayments();
        return new ResponseEntity<>(all,HttpStatus.FOUND);
    }
}
