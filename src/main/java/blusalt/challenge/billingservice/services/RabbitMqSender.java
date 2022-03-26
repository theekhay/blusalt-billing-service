package blusalt.challenge.billingservice.services;

import blusalt.challenge.billingservice.models.Transaction;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class RabbitMqSender {

    private RabbitTemplate rabbitTemplate;

    @Value("${billing.worker.service.routingkey}")
    private String routingKey;

    @Value("${billing.worker.service.exchange}")
    private String billingServiceExchangeKey;


    @Autowired
    public RabbitMqSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void send(Transaction transaction){
        rabbitTemplate.convertAndSend(billingServiceExchangeKey, routingKey, transaction);
    }
}
