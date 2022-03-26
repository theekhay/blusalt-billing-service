package blusalt.challenge.billingservice.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FundResponse {

    private ResponseStatus status;
    private String message;
}
