package com.desafiopicpay.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafiopicpay.domain.transaction.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    
}
