package edu.salleurl.context.users.users.domain

import edu.salleurl.context.shared.domain.valueobject.ValueObject

@ValueObject
data class Email(val value: String) {
    private val patternRegex = "^\\S+@\\S+\$".toRegex()

    init {
        validate()
    }

    private fun validate() {
        if (!patternRegex.matches(value)) throw InvalidEmailException(value)
    }
}

class InvalidEmailException(value: String) : RuntimeException("Invalid email $value")
