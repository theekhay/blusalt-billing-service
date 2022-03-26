package blusalt.challenge.billingservice.interfaces;

import blusalt.challenge.billingservice.dto.FundAccountDTO;
import blusalt.challenge.billingservice.models.FundResponse;
import blusalt.challenge.billingservice.models.ResponseModel;

public interface IBillingService {
    ResponseModel<FundResponse> fund(FundAccountDTO fundAccountDTO);
}
