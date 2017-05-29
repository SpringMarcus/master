package com.kibo.order.controller.json;

import com.kibo.order.config.service.BeanExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RestController annotation — a convenience syntax for @Controller and @ResponseBody together.
 * This means that all the action methods in the marked class will return the JSON response.
 */
@RestController
public class RestControllerExample {

    private final String template = "Hello, %s!";

    @Autowired
    private BeanExample beanExample;

    @ResponseStatus(HttpStatus.MOVED_PERMANENTLY)
    @RequestMapping("/greeting")
    public BeanExample greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        beanExample.setText("Hello, " + name);
        return beanExample;
    }
}
