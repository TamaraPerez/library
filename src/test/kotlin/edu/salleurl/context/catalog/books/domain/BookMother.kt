package edu.salleurl.context.catalog.books.domain

class BookMother {
    companion object {
        fun random(
                id: BookId = BookIdMother.random(),
                name: Name = NameMother.random(),
                author: Author = AuthorMother.random()
        ) = Book(id, name, author)
    }
}
