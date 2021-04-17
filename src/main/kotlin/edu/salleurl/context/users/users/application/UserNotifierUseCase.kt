package edu.salleurl.context.users.users.application

import edu.salleurl.context.users.users.domain.BookName
import edu.salleurl.context.users.users.domain.notifier.UserNotifier
import javax.inject.Named

@Named
class UserNotifierUseCase(private val notifier: UserNotifier) {
    fun execute(bookName: BookName) = notifier.invoke(bookName)
}