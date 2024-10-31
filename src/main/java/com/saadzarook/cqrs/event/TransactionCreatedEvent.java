package com.saadzarook.cqrs.event;

import com.saadzarook.cqrs.model.Transaction;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class TransactionCreatedEvent extends ApplicationEvent {

    private final Transaction transaction;

    public TransactionCreatedEvent(Object source, Transaction transaction) {
        super(source);
        this.transaction = transaction;
    }
}
