package edu.salleurl.context.catalog.books.domain

class BookDoesNotExistException(private val id: BookId): RuntimeException("Book $id does not exist")
