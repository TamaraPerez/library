package edu.salleurl.context.shared.domain.bus.event

import java.time.ZonedDateTime

data class BookCreatedEvent(
    val id: String,
    val name: String,
    val author: String,
    val createdOn: ZonedDateTime = ZonedDateTime.now()
) : DomainEvent(id) {
    override fun type(): String = "book.created"
}