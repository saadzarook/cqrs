package com.saadzarook.cqrs.repository;

import com.saadzarook.cqrs.model.TransactionDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import java.util.List;

public interface TransactionDocumentRepository extends ElasticsearchRepository<TransactionDocument, String> {

    List<TransactionDocument> findByFromAccountOrToAccount(String fromAccount, String toAccount);
}
