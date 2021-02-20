package edu.salleurl.context.catalog.books.infrastructure.controller

import edu.salleurl.context.catalog.books.application.BookCreatorUseCase
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
class BookPostController(val creator: BookCreatorUseCase) {

    @PostMapping("/api/books")
    @ResponseStatus(HttpStatus.CREATED)
    fun post(@RequestBody body: CreateBookRequestBody) {
        creator.execute(id = body.id, name = body.name)
    }
}