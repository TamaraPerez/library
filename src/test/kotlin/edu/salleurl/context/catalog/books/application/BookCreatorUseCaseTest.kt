package edu.salleurl.context.catalog.books.application

import edu.salleurl.context.catalog.books.domain.BookIdMother
import edu.salleurl.context.catalog.books.domain.BookNameMother
import edu.salleurl.context.catalog.books.domain.create.BookCreator
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test


class BookCreatorUseCaseTest {

    private val creator: BookCreator = mockk(relaxed = true)
    private val bookCreatorUseCase = BookCreatorUseCase(creator)

    @Test
    fun `should create a book`() {
        // Given
        val id = BookIdMother.random()
        val name = BookNameMother.random()

        // When
        bookCreatorUseCase.execute(id.value, name.value)

        // Then
        verify { creator.execute(id, name) }
    }
}