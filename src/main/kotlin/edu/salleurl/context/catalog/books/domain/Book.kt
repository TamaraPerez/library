package edu.salleurl.context.catalog.books.domain

data class Book(val id: BookId, val name: Name, val author: Author) {
    companion object {
        fun create(id: BookId, name: Name, author: Author) = Book(id, name, author)
    }
}
