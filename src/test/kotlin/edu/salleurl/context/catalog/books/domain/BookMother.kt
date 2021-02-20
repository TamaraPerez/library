package edu.salleurl.context.catalog.books.domain

class BookMother {
    companion object {
        fun random(id: BookId = BookIdMother.random(), name: BookName = BookNameMother.random()) = Book(id, name)
    }
}
