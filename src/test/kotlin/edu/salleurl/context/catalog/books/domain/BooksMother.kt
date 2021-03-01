package edu.salleurl.context.catalog.books.domain

class BooksMother {
    companion object {
        fun random() = Books(listOf(BookMother.random(), BookMother.random()))
        fun withSameAuthor(author: Author = AuthorMother.random()): Books {
            return Books(listOf(BookMother.random(author = author), BookMother.random(author = author)))
        }
    }
}