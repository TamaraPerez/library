package edu.salleurl.context.catalog.books.domain

import edu.salleurl.context.shared.domain.aggregate.AggregateRoot
import edu.salleurl.context.shared.domain.bus.event.BookCreatedEvent
import edu.salleurl.context.shared.domain.bus.event.DomainEvent

@AggregateRoot
data class Book(
    val id: BookId,
    val name: Name,
    val author: Author,
    private var events: MutableList<DomainEvent> = mutableListOf()
) {
    companion object {
        fun create(id: BookId, name: Name, author: Author) =
            run { Book(id, name, author) }
                .also { it.raise(BookCreatedEvent(id.value, name.value, author.value)) }
    }

    private fun raise(event: DomainEvent) = events.add(event)

    fun pullDomainEvents(): List<DomainEvent> {
        val recordedEvents = events
        events = mutableListOf()

        return recordedEvents
    }
}
