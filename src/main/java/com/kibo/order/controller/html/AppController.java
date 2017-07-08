package com.kibo.order.controller.html;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by marcus.chiu on 10/17/16.
 * @Controller - indicate this class is a controller handling the
 * requests with pattern mapped by @RequestMapping
 */
@Controller
@RequestMapping("/")
public class AppController {

    @RequestMapping(value = {"", "/home"})
    public String home() {
        return "home";
    }
}
