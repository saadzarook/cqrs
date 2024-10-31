package com.saadzarook.cqrs.event;

import com.saadzarook.cqrs.model.Transaction;
import com.saadzarook.cqrs.service.query.TransactionDocumentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class TransactionEventListener {

    private final TransactionDocumentService transactionDocumentService;

    @Async
    @EventListener
    public void handleTransactionCreatedEvent(TransactionCreatedEvent event) {
        Transaction transaction = event.getTransaction();
        log.info("Received TransactionCreatedEvent for transaction ID {}", transaction.getId());
        transactionDocumentService.indexTransaction(transaction);
    }
}

