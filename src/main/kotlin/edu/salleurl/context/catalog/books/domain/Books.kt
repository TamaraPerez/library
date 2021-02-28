package edu.salleurl.context.catalog.books.domain

data class Books(val list: List<Book>) {
   fun count() = list.size
}
