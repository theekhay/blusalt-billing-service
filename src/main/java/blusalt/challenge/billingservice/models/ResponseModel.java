package blusalt.challenge.billingservice.models;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
public class ResponseModel<T> {

    private String status;
    private String message;
    private T data;

    public ResponseModel(String status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
}