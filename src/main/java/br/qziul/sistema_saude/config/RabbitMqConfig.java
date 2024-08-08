package br.qziul.sistema_saude.config;

import org.springframework.amqp.core.Declarable;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {
    public static final String TRIAGEM_QUEUE = "sistema-triagem-queue";

    // Conversão de JSON para Message.
    @Bean
    public Jackson2JsonMessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    // Declarando a Fila.
    @Bean
    public Declarable triagemQueue() {
        return new Queue(TRIAGEM_QUEUE);
    }
}
