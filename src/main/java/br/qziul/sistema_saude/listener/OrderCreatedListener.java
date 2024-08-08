package br.qziul.sistema_saude.listener;

import br.qziul.sistema_saude.dtos.TriagemEventDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import static br.qziul.sistema_saude.config.RabbitMqConfig.TRIAGEM_QUEUE;

@Component
public class OrderCreatedListener {
    private final Logger logger = LoggerFactory.getLogger(OrderCreatedListener.class);

    @RabbitListener(queues = TRIAGEM_QUEUE)
    public void listen(Message<TriagemEventDTO> message) {
        logger.info("Message consumed: {}", message);
    }
}
