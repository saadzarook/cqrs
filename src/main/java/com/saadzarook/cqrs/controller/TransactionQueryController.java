package com.saadzarook.cqrs.controller;

import com.saadzarook.cqrs.model.TransactionDocument;
import com.saadzarook.cqrs.service.query.TransactionDocumentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
@Slf4j
public class TransactionQueryController {

    private final TransactionDocumentService transactionDocumentService;

    @GetMapping("/search")
    public ResponseEntity<List<TransactionDocument>> searchTransactions(@RequestParam String accountId) {
        log.info("Received request to search transactions for account ID {}", accountId);
        List<TransactionDocument> transactions = transactionDocumentService.searchTransactions(accountId);
        log.info("Found {} transactions for account ID {}", transactions.size(), accountId);
        return ResponseEntity.ok(transactions);
    }
}
