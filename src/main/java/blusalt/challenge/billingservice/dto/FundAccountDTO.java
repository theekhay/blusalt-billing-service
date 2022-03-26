package blusalt.challenge.billingservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;


@Data
public class FundAccountDTO {

    @NotNull(message = "amount is required")
    @Positive(message = "amount must be greater than 0")
    private Double amount;

    @NotNull(message = "currency is required")
    @NotEmpty(message = "Kindly provide a value for the currency")
    private String currency;

    @NotNull(message = "channel is required")
    @NotEmpty(message = "Kindly provide a value for the channel")
    private String channel;

    @NotNull(message = "client reference is required")
    @NotEmpty(message = "Kindly provide a value for the client reference")
    @JsonProperty("client_reference")
    private String clientReference;

    @NotNull(message = "Customer id is required")
    @Positive(message = "customer id is invalid")
    @JsonProperty("customer_id")
    private long customerId;
}
