package edu.salleurl.context.catalog.books.domain

import edu.salleurl.context.shared.domain.valueobject.ValueObject

@ValueObject
data class Name(val value: String) {
    init {
        validate()
    }

    private fun validate() {
        if (value.length !in (1..50)) throw InvalidBookNameException(value)
    }
}
