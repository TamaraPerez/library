package edu.salleurl.context.catalog.books.domain

class BookAlreadyExistsException(private val name: Name): RuntimeException("Book with $name already exists")
