package edu.salleurl.context.catalog.books.infrastructure.persistence

import edu.salleurl.context.catalog.books.domain.*
import javax.inject.Named

@Named
class InMemoryBookRepository : BookRepository {

    var books = mutableListOf<Book>()

    override fun save(book: Book) {
        books.add(book)
    }

    override fun existsByName(name: Name): Boolean = books.any { it.name == name }
    override fun exists(id: BookId): Boolean = books.any { it.id == id }

    override fun all(): Books = Books(books)
    override fun find(id: BookId): Book = books.find { it.id == id }!!

    override fun search(author: Author): Books? {
        val booksWithTheSameAuthor = books.filter { it.author == author }

        if (booksWithTheSameAuthor.isEmpty()) return null

        return Books(booksWithTheSameAuthor)
    }
}