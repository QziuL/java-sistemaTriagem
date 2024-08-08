package br.qziul.sistema_saude.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    public static final String TRIAGEM_QUEUE = "sistema-triagem-queue";
}
