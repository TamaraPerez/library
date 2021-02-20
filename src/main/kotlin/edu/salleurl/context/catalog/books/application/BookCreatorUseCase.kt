package edu.salleurl.context.catalog.books.application

import edu.salleurl.context.catalog.books.domain.BookId
import edu.salleurl.context.catalog.books.domain.BookName
import edu.salleurl.context.catalog.books.domain.create.BookCreator
import javax.inject.Named

@Named
class BookCreatorUseCase(private val creator: BookCreator) {

    fun execute(id: String, name: String) {
        creator.execute(BookId(id), BookName(name))
    }
}