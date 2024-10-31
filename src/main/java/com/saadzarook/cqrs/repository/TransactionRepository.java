package com.saadzarook.cqrs.repository;

import com.saadzarook.cqrs.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}