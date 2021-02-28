package edu.salleurl.context.catalog.books.domain.search

import edu.salleurl.context.catalog.books.domain.Author
import edu.salleurl.context.catalog.books.domain.BookRepository
import edu.salleurl.context.catalog.books.domain.Books
import javax.inject.Named

@Named
class BooksByAuthorSearcher(private val repository: BookRepository) {

    fun execute(author: Author): Books? = repository.search(author)
}