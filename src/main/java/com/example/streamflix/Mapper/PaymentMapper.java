package com.example.streamflix.Mapper;

import com.example.streamflix.Model.DTO.PaymentDto;
import com.example.streamflix.Model.Entity.Payment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "Spring")
public interface PaymentMapper {

    PaymentMapper INSTANCE = Mappers.getMapper(PaymentMapper.class);

    @Mapping(source = "user.id", target = "userId")
    PaymentDto toPaymentDto(Payment payment);

    @Mapping(target = "user" , expression = "java(new User(paymentDto.getUserId()))")
    Payment toPayment(PaymentDto paymentDto);
}
