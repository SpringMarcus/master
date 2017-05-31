package com.kibo.order.controller.json.order.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class OrderRequest {
    @JsonProperty("customer_id")
    private long customerId;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;

    @JsonIgnore
    private Integer currencyId;
    @JsonIgnore
    private Integer languageId;

    @JsonProperty("customer")
    private CustomerRequest customerRequest;
}
