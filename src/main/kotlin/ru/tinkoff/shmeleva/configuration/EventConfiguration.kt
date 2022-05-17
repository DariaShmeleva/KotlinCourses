package ru.tinkoff.shmeleva.configuration

import org.apache.activemq.command.ActiveMQQueue
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class EventConfiguration {
    @Bean
    fun queue() = ActiveMQQueue("eventQueue")
}