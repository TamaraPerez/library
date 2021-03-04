package edu.salleurl.context.catalog.books.infrastucture.persistence

import edu.salleurl.context.catalog.books.domain.*
import edu.salleurl.context.catalog.books.infrastructure.persistence.InMemoryBookRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class InMemoryBookRepositoryShould {

    @Test
    fun `should save a book`() {
        //Given
        val repository = InMemoryBookRepository()
        val book = BookMother.random()

        //When
        repository.save(book)

        //Then
        assertThat(repository.exists(book.id)).isTrue
    }

    @Test
    fun `should check if a book exists by name`() {
        //Given
        val repository = InMemoryBookRepository()
        val book1 = BookMother.random()
        val book2 = BookMother.random()

        //When
        repository.save(book1)

        //Then
        assertThat(repository.existsByName(book1.name)).isTrue
        assertThat(repository.existsByName(book2.name)).isFalse
    }

    @Test
    fun `should check if a book exists by id`() {
        //Given
        val repository = InMemoryBookRepository()
        val book1 = BookMother.random()
        val book2 = BookMother.random()

        //When
        repository.save(book1)

        //Then
        assertThat(repository.exists(book1.id)).isTrue
        assertThat(repository.exists(book2.id)).isFalse
    }

    @Test
    fun `should find all books`() {
        //Given
        val repository = InMemoryBookRepository()
        val books = BooksMother.random()

        //When
        books.list.forEach { repository.save(it) }

        //Then
        assertThat(repository.all()).isEqualTo(books)
    }

    @Test
    fun `should find a book by id`() {
        //Given
        val repository = InMemoryBookRepository()
        val book = BookMother.random()

        //When
        repository.save(book)

        //Then
        assertThat(repository.find(book.id)).isEqualTo(book)
    }

    @Test
    fun `should search books by author`() {
        //Given
        val repository = InMemoryBookRepository()
        val author = AuthorMother.random()
        val books = BooksMother.withSameAuthor(author)

        //When
        books.list.forEach { repository.save(it) }

        //Then
        assertThat(repository.search(author)).isEqualTo(books)
    }
}