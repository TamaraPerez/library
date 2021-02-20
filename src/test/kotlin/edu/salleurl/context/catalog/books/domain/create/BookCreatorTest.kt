package edu.salleurl.context.catalog.books.domain.create

import edu.salleurl.context.catalog.books.domain.*
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.amshove.kluent.`should throw`
import org.amshove.kluent.invoking
import org.junit.jupiter.api.Test

class BookCreatorTest {

    private val repository: BookRepository = mockk(relaxed = true)
    private val creator = BookCreator(repository)

    @Test
    fun `should create a book`() {
        //Given
        val id = BookIdMother.random()
        val name = BookNameMother.random()
        every { repository.existsByName(name) } returns false

        //When
        creator.execute(id, name)

        //Then
        val book = BookMother.random(id, name)
        verify { repository.save(book) }
    }

    @Test
    fun `should throw an exception when the book name already exists`() {
        //Given
        val id = BookIdMother.random()
        val name = BookNameMother.random()
        every { repository.existsByName(name) } returns true

        //When
        invoking { creator.execute(id, name) } `should throw` BookAlreadyExistsException::class

        //Then
        val book = BookMother.random(id, name)
        verify(exactly = 0) { repository.save(book) }
    }
}