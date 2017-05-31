package com.kibo.order.controller.json.order.response;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class OrderResponse {

    private Boolean success;
    private List<String> errorMessages;

    public OrderResponse() {
        errorMessages = new ArrayList<>();
    }

    public void addErrorMessage(String errorMessage) {
        errorMessages.add(errorMessage);
    }
}
