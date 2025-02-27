package com.example.streamflix.Service.Payment;


import com.example.streamflix.Exception.ResourceNotFoundException;
import com.example.streamflix.Mapper.PaymentMapper;
import com.example.streamflix.Model.DTO.PaymentDto;
import com.example.streamflix.Model.Entity.Payment;
import com.example.streamflix.Model.Entity.User;
import com.example.streamflix.Repository.PaymentRepository;
import com.example.streamflix.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

private final PaymentRepository paymentRepository;
private final UserRepository userRepository;
private final PaymentMapper paymentMapper;

public PaymentServiceImpl(PaymentRepository paymentRepository,
                          UserRepository userRepository,
                          PaymentMapper paymentMapper){
    this.paymentMapper=paymentMapper;
    this.paymentRepository=paymentRepository;
    this.userRepository=userRepository;
}


    @Override
    public PaymentDto processPayment(PaymentDto paymentDto) {

    User user =userRepository.findById(paymentDto.getUserId()).orElseThrow(
            ()->new ResourceNotFoundException("User not found")
    );

    Payment payment = paymentMapper.toPayment(paymentDto);
    payment.setUser(user);

    Payment savedPayment = paymentRepository.save(payment);
        return paymentMapper.toPaymentDto(savedPayment);
    }

    @Override
    public PaymentDto getPaymentByTransactionId(String transactionId) {
    Payment payment =paymentRepository.findByTransactionId(transactionId).orElseThrow(
            ()-> new ResourceNotFoundException("Payment not Found")
    );
        return paymentMapper.toPaymentDto(payment);
    }

    @Override
    public List<PaymentDto> getAllPayments() {

        return paymentRepository.findAll().stream().map(paymentMapper::toPaymentDto).toList();
    }
}
