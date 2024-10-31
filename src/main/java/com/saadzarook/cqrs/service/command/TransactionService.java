package com.saadzarook.cqrs.service.command;

import com.saadzarook.cqrs.event.TransactionCreatedEvent;
import com.saadzarook.cqrs.model.Transaction;
import com.saadzarook.cqrs.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final ApplicationEventPublisher applicationEventPublisher;


    @Transactional
    public Transaction createTransaction(Transaction transaction) {
        log.info("Creating transaction from {} to {} amount {}", transaction.getFromAccount(), transaction.getToAccount(), transaction.getAmount());

        // Business logic for transaction creation
        transaction.setTimestamp(LocalDateTime.now());
        Transaction savedTransaction = transactionRepository.save(transaction);
        log.info("Transaction saved with ID {}", savedTransaction.getId());

        // Publish the event
        applicationEventPublisher.publishEvent(new TransactionCreatedEvent(this, savedTransaction));
        log.info("TransactionCreatedEvent published for transaction ID {}", savedTransaction.getId());

        return savedTransaction;
    }
}

