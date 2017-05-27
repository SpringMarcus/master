package com.kibo.order.bean;

import lombok.Data;

/**
 * Created by marcus.chiu on 10/28/16.
 */
@Data
public class BeanExample {

    private String text = "Hello Lombok is awesome";

    public BeanExample() {
        System.out.println("BeanExample: constructor");
    }

    public void initialization() {
        System.out.println("BeanExample: initialization");
    }

    public void destruction() {
        System.out.println("BeanExample: destruction");
    }
}
