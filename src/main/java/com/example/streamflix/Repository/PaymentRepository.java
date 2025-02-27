package com.example.streamflix.Repository;

import com.example.streamflix.Model.DTO.PaymentDto;
import com.example.streamflix.Model.Entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment , Long> {

    Optional<Payment> findByTransactionId (String transactionId);
}
