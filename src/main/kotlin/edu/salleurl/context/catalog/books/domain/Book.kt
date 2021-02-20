package edu.salleurl.context.catalog.books.domain

data class Book(val id: BookId, val name: BookName) {
    companion object {
        fun create(id: BookId, name: BookName) = Book(id, name)
    }
}
