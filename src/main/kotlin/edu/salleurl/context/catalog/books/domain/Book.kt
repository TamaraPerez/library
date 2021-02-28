package edu.salleurl.context.catalog.books.domain

data class Book(val id: BookId, val name: Name) {
    companion object {
        fun create(id: BookId, name: Name) = Book(id, name)
    }
}
