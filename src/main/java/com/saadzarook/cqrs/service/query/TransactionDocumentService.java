package com.saadzarook.cqrs.service.query;

import com.saadzarook.cqrs.model.Transaction;
import com.saadzarook.cqrs.model.TransactionDocument;
import com.saadzarook.cqrs.repository.TransactionDocumentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransactionDocumentService {

    private final TransactionDocumentRepository transactionDocumentRepository;

    public void indexTransaction(Transaction transaction) {
        log.info("Indexing transaction ID {} for query side", transaction.getId());

        TransactionDocument doc = new TransactionDocument();
        doc.setId(transaction.getId().toString());
        doc.setFromAccount(transaction.getFromAccount());
        doc.setToAccount(transaction.getToAccount());
        doc.setAmount(transaction.getAmount());
        doc.setTimestamp(transaction.getTimestamp());

        transactionDocumentRepository.save(doc);
        log.info("Transaction ID {} indexed successfully", transaction.getId());
    }

    public List<TransactionDocument> searchTransactions(String accountId) {
        log.info("Searching transactions for account ID {}", accountId);
        return transactionDocumentRepository.findByFromAccountOrToAccount(accountId, accountId);
    }
}

