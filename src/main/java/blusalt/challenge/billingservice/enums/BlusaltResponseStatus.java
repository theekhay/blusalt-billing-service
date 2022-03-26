package blusalt.challenge.billingservice.enums;


import lombok.Getter;

@Getter
public enum BlusaltResponseStatus {

    SUCCESS("00"),
    FAILED("99");

    private String code;

    BlusaltResponseStatus(String code) {
        this.code = code;
    }
}
