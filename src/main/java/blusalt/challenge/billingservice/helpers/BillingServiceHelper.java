package blusalt.challenge.billingservice.helpers;

import blusalt.challenge.billingservice.enums.BlusaltResponseStatus;
import blusalt.challenge.billingservice.models.ResponseModel;

public class BillingServiceHelper {


    public static final String SUCCESS_MESSAGE = "Operation successful";
    public static final String ERROR_MESSAGE = "Operation FAILED";
    public static final String REQUEST_FAILED="99";



    public static ResponseModel buildSuccessfulResposne(Object data){
        return new ResponseModel(BlusaltResponseStatus.SUCCESS.getCode(), SUCCESS_MESSAGE, data);
    }

    public static ResponseModel buildErrorResposne(Object data) {
        return new ResponseModel(BlusaltResponseStatus.FAILED.getCode(), ERROR_MESSAGE, data);
    }

    public static ResponseModel buildErrorResposne(){
        return new ResponseModel(BlusaltResponseStatus.FAILED.getCode(), ERROR_MESSAGE, null);
    }
}
