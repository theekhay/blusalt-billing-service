package blusalt.challenge.billingservice.enums;


import lombok.Getter;

@Getter
public enum PaymentStatus {

    SUCCESS("SUCCESS"),
    PENDING("PENDING"),
    FAILED("FAILED");

    private String code;

    PaymentStatus(String code) {
        this.code = code;
    }
}
