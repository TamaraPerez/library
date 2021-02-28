package edu.salleurl.context.catalog.books.domain

import com.github.javafaker.Faker

class AuthorMother {
    companion object {
        fun random() = Author(Faker().book().author())
    }
}