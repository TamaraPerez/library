package edu.salleurl.context.catalog.books.infrastructure.persistence

import edu.salleurl.context.catalog.books.domain.Book
import edu.salleurl.context.catalog.books.domain.Name
import edu.salleurl.context.catalog.books.domain.BookRepository
import javax.inject.Named

@Named
class InMemoryBookRepository : BookRepository {

    var books = mutableListOf<Book>()

    override fun save(book: Book) {
        books.add(book)
    }

    override fun existsByName(name: Name): Boolean = books.any { it.name == name }
}