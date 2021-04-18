package edu.salleurl.context.shared.domain.bus.event

import java.time.ZonedDateTime

abstract class DomainEvent(
    private val aggregateId: String,
    val metadata: DomainEventMetadata = DomainEventMetadata(aggregateId)
) {
    abstract fun type(): String
}

data class DomainEventMetadata(
    val aggregateId: String,
    val occurredOn: ZonedDateTime = ZonedDateTime.now()
)