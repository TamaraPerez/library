package edu.salleurl.context.catalog.books.acceptance

import edu.salleurl.context.LibraryApplication
import edu.salleurl.context.catalog.books.domain.AuthorMother
import edu.salleurl.context.catalog.books.domain.BookIdMother
import edu.salleurl.context.catalog.books.domain.NameMother
import io.restassured.RestAssured.*
import io.restassured.http.ContentType
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus

@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT,
    classes = [LibraryApplication::class]
)
class ApiShould {

    private val bookId = BookIdMother.random()
    private val bookName = NameMother.random()
    private val bookAuthor = AuthorMother.random()

    private val createBody = """
        {
            "id": "${bookId.value}",
            "name": "${bookName.value}",
            "author": "${bookAuthor.value}"
        }
        """

    @Test
    fun `creates a book`() {
        given()
            .contentType(ContentType.JSON)
            .body(createBody)
            .post("/api/books")
            .then().assertThat()
            .statusCode(HttpStatus.CREATED.value())
    }
}