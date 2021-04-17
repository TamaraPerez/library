package edu.salleurl.context.catalog.books.application

import edu.salleurl.context.catalog.books.domain.AuthorMother
import edu.salleurl.context.catalog.books.domain.BookIdMother
import edu.salleurl.context.catalog.books.domain.NameMother
import edu.salleurl.context.catalog.books.domain.create.BookCreator
import edu.salleurl.context.shared.domain.bus.event.BookCreatedEvent
import edu.salleurl.context.shared.domain.bus.publisher.EventPublisher
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkStatic
import io.mockk.verify
import org.junit.jupiter.api.Test
import java.time.ZonedDateTime


class BookCreatorUseCaseTest {

    private val creator: BookCreator = mockk(relaxed = true)
    private val publisher: EventPublisher = mockk(relaxed = true)
    private val bookCreatorUseCase = BookCreatorUseCase(creator, publisher)

    @Test
    fun `should create a book`() {
        // Given
        val id = BookIdMother.random()
        val name = NameMother.random()
        val author = AuthorMother.random()

        // When
        mockZonedDateTime()
        bookCreatorUseCase.execute(id.value, name.value, author.value)

        // Then
        verify { creator.invoke(id, name, author) }
        verify { publisher.publish(any<List<BookCreatedEvent>>()) }
    }
}

internal fun mockZonedDateTime() {
    mockkStatic(ZonedDateTime::class)
    val occurredOn = ZonedDateTime.now()
    every { ZonedDateTime.now() } returns occurredOn
}