package com.omartahri.cqrs_axon.queries.services;

import org.axonframework.eventsourcing.eventstore.DomainEventStream;


public interface EventSourcingService {
    DomainEventStream eventsByAccountId(String accountId);
}
