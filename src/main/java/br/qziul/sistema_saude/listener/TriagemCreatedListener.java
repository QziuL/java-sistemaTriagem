package br.qziul.sistema_saude.listener;

import br.qziul.sistema_saude.events.TriagemEvent;
import br.qziul.sistema_saude.models.entitys.TriagemEntity;
import br.qziul.sistema_saude.service.TriagemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import static br.qziul.sistema_saude.config.RabbitMqConfig.TRIAGEM_QUEUE;

@Component
public class TriagemCreatedListener {
    private final Logger logger = LoggerFactory.getLogger(TriagemCreatedListener.class);

    @Autowired
    private TriagemService triagemService;

    @RabbitListener(queues = TRIAGEM_QUEUE)
    public void listen(Message<TriagemEvent> message) {
        logger.info("MESSAGE CONSUMED: {}", message);
        triagemService.save(message.getPayload().toEntity());
    }
}
