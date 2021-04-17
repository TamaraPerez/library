package edu.salleurl.context.users.users.domain

interface EmailSender {
    fun invoke(to: Email, bookName: BookName)
}