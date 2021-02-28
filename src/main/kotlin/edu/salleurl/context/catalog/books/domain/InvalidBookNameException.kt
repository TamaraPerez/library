package edu.salleurl.context.catalog.books.domain

class InvalidBookNameException(private val name: String) : RuntimeException("Book name $name is invalid")
