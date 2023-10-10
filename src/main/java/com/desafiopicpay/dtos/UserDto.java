package com.desafiopicpay.dtos;

import java.math.BigDecimal;

import com.desafiopicpay.domain.user.UserType;

public record UserDto(String firstName, String lastName, String document, BigDecimal balance, String email, String password, UserType userType) {
    
}
