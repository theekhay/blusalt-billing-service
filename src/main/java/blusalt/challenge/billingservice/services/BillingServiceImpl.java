package blusalt.challenge.billingservice.services;


import blusalt.challenge.billingservice.dao.TransactionDao;
import blusalt.challenge.billingservice.dto.FundAccountDTO;
import blusalt.challenge.billingservice.interfaces.IBillingService;
import blusalt.challenge.billingservice.models.FundResponse;
import blusalt.challenge.billingservice.models.ResponseModel;
import blusalt.challenge.billingservice.models.Transaction;
import blusalt.challenge.billingservice.utilities.Common;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static blusalt.challenge.billingservice.helpers.BillingServiceHelper.buildErrorResposne;
import static blusalt.challenge.billingservice.helpers.BillingServiceHelper.buildSuccessfulResposne;


@Slf4j
@Service("IBillingService")
public class BillingServiceImpl implements IBillingService {

    private final TransactionDao transactionDao;
    private final ModelMapper modelMapper;
    private final RabbitMqSender rabbitMqSender;


    @Autowired
    public BillingServiceImpl(TransactionDao transactionDao, ModelMapper modelMapper, RabbitMqSender rabbitMqSender) {
        this.transactionDao = transactionDao;
        this.modelMapper = modelMapper;
        this.rabbitMqSender = rabbitMqSender;
    }

    @Override
    public ResponseModel<FundResponse> fund(FundAccountDTO fundAccountDTO) {

        var transaction = modelMapper.map(fundAccountDTO, Transaction.class);
        transaction.setReference(Common.generateRef(7, "TT-"));
        transaction = transactionDao.save(transaction);

        try {
            rabbitMqSender.send( transaction);
        } catch (Exception e) {
           return buildErrorResposne(e.getMessage());
        }
        return buildSuccessfulResposne(transaction);
    }
}
