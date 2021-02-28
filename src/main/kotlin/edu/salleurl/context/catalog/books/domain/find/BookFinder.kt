package edu.salleurl.context.catalog.books.domain.find

import edu.salleurl.context.catalog.books.domain.*
import edu.salleurl.context.catalog.books.domain.search.BooksByAuthorSearcher
import javax.inject.Named

@Named
class BookFinder(private val repository: BookRepository) {

    fun invoke(id: BookId): Book {
        guard(id)

        return repository.find(id)
    }

    private fun guard(id: BookId) {
        if (!repository.exists(id)) throw BookDoesNotExistException(id)
    }
}