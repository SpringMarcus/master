package com.kibo.order.controller.json.order.validator;

import com.kibo.order.controller.json.order.request.OrderRequest;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class OrderWebDataValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return OrderRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        OrderRequest orderRequest = (OrderRequest)o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "","first name is empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "", "last name is empty");

        if (orderRequest.getCustomerId() <= 0) {
            errors.rejectValue("customerId","", "customerId must be greater than 0");
        }
    }
}
