package com.saadzarook.cqrs.model;

import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Document(indexName = "transactions")
@Data
@NoArgsConstructor
public class TransactionDocument {

    @Id
    private String id;

    private String fromAccount;
    private String toAccount;
    private BigDecimal amount;
    private LocalDateTime timestamp;
}

