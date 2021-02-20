package edu.salleurl.context.catalog.books.domain.create

import edu.salleurl.context.catalog.books.domain.*
import javax.inject.Named

@Named
class BookCreator(private val repository: BookRepository) {

    fun execute(id: BookId, name: BookName) {
        guardBookExists(name)

        Book.create(id, name).let { repository.save(it) }
    }

    private fun guardBookExists(name: BookName) {
        if (repository.existsByName(name)) throw BookAlreadyExistsException(name)
    }
}