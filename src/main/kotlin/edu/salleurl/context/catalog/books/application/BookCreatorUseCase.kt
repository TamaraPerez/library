package edu.salleurl.context.catalog.books.application

import edu.salleurl.context.catalog.books.domain.Author
import edu.salleurl.context.catalog.books.domain.BookId
import edu.salleurl.context.catalog.books.domain.Name
import edu.salleurl.context.catalog.books.domain.create.BookCreator
import javax.inject.Named

@Named
class BookCreatorUseCase(private val creator: BookCreator) {

    fun execute(id: String, name: String, author: String) {
        creator.invoke(BookId(id), Name(name), Author(author))
    }
}