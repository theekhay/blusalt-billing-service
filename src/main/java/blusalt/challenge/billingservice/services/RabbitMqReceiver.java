package blusalt.challenge.billingservice.services;


import blusalt.challenge.billingservice.dao.TransactionDao;
import blusalt.challenge.billingservice.enums.PaymentStatus;
import blusalt.challenge.billingservice.models.ResponseModel;
import blusalt.challenge.billingservice.models.Transaction;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RabbitMqReceiver implements RabbitListenerConfigurer {

    private final TransactionDao transactionDao;
    private final ModelMapper modelMapper;

    public RabbitMqReceiver(TransactionDao transactionDao, ModelMapper modelMapper) {
        this.transactionDao = transactionDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public void configureRabbitListeners(RabbitListenerEndpointRegistrar rabbitListenerEndpointRegistrar) {
    }

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void receivedMessage(ResponseModel responseModel) {
        log.info("transaction Details Received is {}", responseModel);

        ObjectMapper mapper = new ObjectMapper();
        var transaction = modelMapper.map(responseModel.getData(), Transaction.class);
        log.info("transaction {}", transaction);

        if( null != transaction.getId()){
            transaction.setStatus(PaymentStatus.SUCCESS);
            transactionDao.save(transaction);
        }
    }
}
