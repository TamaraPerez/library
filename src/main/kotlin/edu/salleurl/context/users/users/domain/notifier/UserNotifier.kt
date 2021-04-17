package edu.salleurl.context.users.users.domain.notifier

import edu.salleurl.context.users.users.domain.BookName
import edu.salleurl.context.users.users.domain.EmailSender
import edu.salleurl.context.users.users.domain.UserRepository
import javax.inject.Named

@Named
class UserNotifier(private val repository: UserRepository, private val sender: EmailSender) {

    fun invoke(bookName: BookName) {
        repository.all().list.forEach { user ->
            sender.invoke(user.email, bookName)
        }
    }
}