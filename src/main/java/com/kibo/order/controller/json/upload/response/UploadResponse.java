package com.kibo.order.controller.json.upload.response;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UploadResponse {

    private Boolean success;
    private List<String> errorMessages;

    private String fileName;

    public UploadResponse() {
        errorMessages = new ArrayList<>();
    }

    public void addErrorMessage(String errorMessage) {
        errorMessages.add(errorMessage);
    }
}
