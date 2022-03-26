package blusalt.challenge.billingservice.controllers;


import blusalt.challenge.billingservice.dto.FundAccountDTO;
import blusalt.challenge.billingservice.interfaces.IBillingService;
import blusalt.challenge.billingservice.models.FundResponse;
import blusalt.challenge.billingservice.models.ResponseModel;
import blusalt.challenge.billingservice.services.RabbitMqSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class BillingServiceController {

    private final IBillingService billingService;

    @Autowired
    public BillingServiceController(IBillingService billingService, RabbitMqSender rabbitMqSender) {
        this.billingService = billingService;
    }

    @PostMapping("/fund")
    public ResponseEntity<ResponseModel<FundResponse>> createCustomer(@Validated @RequestBody FundAccountDTO fundAccountDTO){
        return ResponseEntity.ok(billingService.fund(fundAccountDTO));
    }
}
