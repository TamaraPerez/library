package edu.salleurl.context.catalog.books.domain

import edu.salleurl.context.shared.domain.aggregate.AggregateRoot

data class Book(val id: BookId, val name: Name, val author: Author): AggregateRoot() {
    companion object {
        fun create(id: BookId, name: Name, author: Author) = Book(id, name, author)
    }
}
