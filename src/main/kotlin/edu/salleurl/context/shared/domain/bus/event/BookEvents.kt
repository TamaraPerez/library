package edu.salleurl.context.shared.domain.bus.event

data class BookCreatedEvent(
    val id: String,
    val name: String,
    val author: String
) : DomainEvent(id) {
    override fun type(): String = "book.created"
}