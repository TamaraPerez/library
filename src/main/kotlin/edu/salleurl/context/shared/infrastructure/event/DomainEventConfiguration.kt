package edu.salleurl.context.shared.infrastructure.event

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.amqp.support.converter.MessageConverter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DomainEventConfiguration(private val objectMapper: ObjectMapper) {

    @Bean
    fun jsonMessageConverter(): MessageConverter = Jackson2JsonMessageConverter(objectMapper)
}