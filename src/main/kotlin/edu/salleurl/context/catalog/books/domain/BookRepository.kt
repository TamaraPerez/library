package edu.salleurl.context.catalog.books.domain

interface BookRepository {
    fun save(book: Book)
    fun existsByName(name: Name): Boolean
    fun exists(id: BookId): Boolean
    fun all(): Books
    fun find(id: BookId): Book
    fun search(author: Author): Books?
}