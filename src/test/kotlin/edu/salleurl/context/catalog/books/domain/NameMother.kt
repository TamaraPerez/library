package edu.salleurl.context.catalog.books.domain

import com.github.javafaker.Faker

class NameMother {
    companion object {
        fun random() = Name(Faker().book().title().take(30))
    }
}