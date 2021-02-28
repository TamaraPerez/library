package edu.salleurl.context.catalog.books.domain

import com.github.javafaker.Faker

class BookNameMother {
    companion object {
        fun random() = Name(Faker().book().title())
    }
}