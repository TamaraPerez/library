package edu.salleurl.context.shared.domain.aggregate

import edu.salleurl.context.shared.domain.bus.event.DomainEvent

abstract class AggregateRoot {
    private var domainEvents = mutableListOf<DomainEvent>()

    fun pullDomainEvents(): List<DomainEvent> {
        val currentDomainEvents = domainEvents
        domainEvents = mutableListOf()

        return currentDomainEvents
    }

    fun record(domainEvent: DomainEvent) {
        domainEvents.add(domainEvent)
    }
}