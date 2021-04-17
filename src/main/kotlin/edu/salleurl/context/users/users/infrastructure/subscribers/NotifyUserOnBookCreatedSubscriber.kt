package edu.salleurl.context.users.users.infrastructure.subscribers

import edu.salleurl.context.shared.domain.bus.event.BookCreatedEvent
import edu.salleurl.context.users.users.application.UserNotifierUseCase
import edu.salleurl.context.users.users.domain.BookName
import org.springframework.amqp.rabbit.annotation.RabbitListener
import javax.inject.Named

@Named
class NotifyUserOnBookCreatedSubscriber(private val useCase: UserNotifierUseCase) {

    @RabbitListener(queues = ["notify_user_on_book_created"])
    fun on(event: BookCreatedEvent) {
        useCase.execute(BookName(event.name))
    }
}