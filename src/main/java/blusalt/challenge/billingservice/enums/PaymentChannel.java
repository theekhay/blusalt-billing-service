package blusalt.challenge.billingservice.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

@Getter
public enum PaymentChannel {

    CASH("CASH"),
    POS("POS"),
    TRANSFER("TRANSFER");

    private String name;

    PaymentChannel(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @JsonCreator
    public static PaymentChannel getEnum(String value) {
        for (PaymentChannel v : values())
            if (v.getName().equalsIgnoreCase(value)) return v;
        throw new IllegalArgumentException(value);
    }
}
