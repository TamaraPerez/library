package edu.salleurl.context.catalog.books.application

import edu.salleurl.context.catalog.books.domain.Author
import edu.salleurl.context.catalog.books.domain.BookId
import edu.salleurl.context.catalog.books.domain.Name
import edu.salleurl.context.catalog.books.domain.create.BookCreator
import edu.salleurl.context.shared.domain.bus.publisher.EventPublisher
import javax.inject.Named

@Named
class BookCreatorUseCase(
    private val creator: BookCreator,
    private val publisher: EventPublisher
) {

    fun execute(id: String, name: String, author: String) {
        creator.invoke(BookId(id), Name(name), Author(author))
            .also { publisher.publish(it.pullDomainEvents()) }
    }
}