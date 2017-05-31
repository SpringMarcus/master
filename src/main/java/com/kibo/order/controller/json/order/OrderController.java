package com.kibo.order.controller.json.order;

import com.kibo.order.controller.json.order.response.OrderResponse;
import com.kibo.order.controller.json.order.validator.OrderWebDataValidator;
import com.kibo.order.controller.json.order.request.OrderRequest;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    @InitBinder
    public void dataBinding(WebDataBinder binder) {
        binder.addValidators(new OrderWebDataValidator());
    }

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public OrderResponse createOrder(@RequestBody @Validated OrderRequest orderRequest, BindingResult bindingResult){
        OrderResponse response = new OrderResponse();

        if (bindingResult.hasErrors()) {
            response.setSuccess(false);
            for (ObjectError oe : bindingResult.getAllErrors()) {
                response.addErrorMessage(oe.getDefaultMessage());
            }
        } else {
            response.setSuccess(true);
        }

        return response;
    }
}
