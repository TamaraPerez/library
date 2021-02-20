package edu.salleurl.context.catalog.books.domain

interface BookRepository {
    fun save(book: Book)
    fun existsByName(name: BookName): Boolean
}