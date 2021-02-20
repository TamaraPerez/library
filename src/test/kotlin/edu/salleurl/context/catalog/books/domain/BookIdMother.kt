package edu.salleurl.context.catalog.books.domain

import java.util.UUID

class BookIdMother {
    companion object {
        fun random() = BookId(UUID.randomUUID().toString())
    }
}