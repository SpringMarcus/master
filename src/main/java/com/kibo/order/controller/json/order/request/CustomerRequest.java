package com.kibo.order.controller.json.order.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomerRequest {
    @JsonProperty("customer_id")
    private long customerId;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
}
