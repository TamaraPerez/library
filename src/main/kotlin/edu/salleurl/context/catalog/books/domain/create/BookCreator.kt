package edu.salleurl.context.catalog.books.domain.create

import edu.salleurl.context.catalog.books.domain.*
import javax.inject.Named

@Named
class BookCreator(private val repository: BookRepository) {

    fun invoke(id: BookId, name: Name, author: Author) {
        guardBookDoesNotExist(name)

        Book.create(id, name, author).let { repository.save(it) }
    }

    private fun guardBookDoesNotExist(name: Name) {
        if (repository.existsByName(name)) throw BookAlreadyExistsException(name)
    }
}