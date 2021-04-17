package edu.salleurl.context.users.users.infrastructure.notification

import edu.salleurl.context.users.users.domain.Email
import edu.salleurl.context.users.users.domain.EmailSender
import edu.salleurl.context.users.users.domain.BookName
import javax.inject.Named

@Named
class PendingEmailSender : EmailSender {
    override fun invoke(to: Email, bookName: BookName) {
        TODO("Not yet implemented")
    }
}