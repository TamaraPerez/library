package edu.salleurl.context.shared.domain.bus.publisher

import edu.salleurl.context.shared.domain.bus.event.DomainEvent

interface EventPublisher {
    fun publish(event: DomainEvent)
    fun publish(events: List<DomainEvent>)
}