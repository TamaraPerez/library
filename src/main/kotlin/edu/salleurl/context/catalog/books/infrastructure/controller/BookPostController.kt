package edu.salleurl.context.catalog.books.infrastructure.controller

import edu.salleurl.context.catalog.books.application.BookCreatorUseCase
import edu.salleurl.context.catalog.books.domain.BookAlreadyExistsException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
class BookPostController(val creator: BookCreatorUseCase) {

    @PostMapping("/api/books")
    @ResponseStatus(HttpStatus.CREATED)
    fun post(@RequestBody body: CreateBookRequestBody) {
        creator.execute(id = body.id, name = body.name, author = body.author)
    }

    @RestControllerAdvice(assignableTypes = [BookPostController::class])
    class BookPostControllerExceptionHandler {
        @ExceptionHandler(BookAlreadyExistsException::class)
        @ResponseStatus(HttpStatus.CONFLICT)
        fun handle(e: BookAlreadyExistsException) = e
    }
}