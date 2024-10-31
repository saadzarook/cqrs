package com.saadzarook.cqrs.controller;

import com.saadzarook.cqrs.model.Transaction;
import com.saadzarook.cqrs.service.command.TransactionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
@Slf4j
public class TransactionCommandController {

    private final TransactionService transactionService;

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) {
        log.info("Received request to create transaction");
        Transaction savedTransaction = transactionService.createTransaction(transaction);
        log.info("Transaction created with ID {}", savedTransaction.getId());
        return ResponseEntity.ok(savedTransaction);
    }
}
