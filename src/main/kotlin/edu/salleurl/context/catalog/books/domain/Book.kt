package edu.salleurl.context.catalog.books.domain

import edu.salleurl.context.shared.domain.aggregate.AggregateRoot

@AggregateRoot
data class Book(val id: BookId, val name: Name, val author: Author) {
    companion object {
        fun create(id: BookId, name: Name, author: Author) = Book(id, name, author)
    }
}
