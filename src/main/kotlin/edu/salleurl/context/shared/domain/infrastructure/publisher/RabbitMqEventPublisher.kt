package edu.salleurl.context.shared.domain.infrastructure.publisher

import edu.salleurl.context.shared.domain.bus.event.DomainEvent
import edu.salleurl.context.shared.domain.bus.publisher.EventPublisher
import org.springframework.amqp.rabbit.core.RabbitTemplate
import javax.inject.Named

@Named
class RabbitMqEventPublisher(private val rabbitTemplate: RabbitTemplate) : EventPublisher {
    override fun publish(event: DomainEvent) = sendEvent(event)

    override fun publish(events: List<DomainEvent>) =
        events.forEach { event ->
            sendEvent(event)
        }

    private fun sendEvent(event: DomainEvent) {
        rabbitTemplate.convertAndSend("domain_events", event.type(), event)
    }
}