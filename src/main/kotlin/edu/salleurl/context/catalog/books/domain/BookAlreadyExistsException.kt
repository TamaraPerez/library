package edu.salleurl.context.catalog.books.domain

class BookAlreadyExistsException(private val name: BookName): RuntimeException("Book with $name already exists")
