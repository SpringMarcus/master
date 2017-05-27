package com.kibo.order.config;

import com.kibo.order.a_bean.BeanExample;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by marcus.chiu on 10/28/16.
 * @Configuration - indicates this class can be used by the Spring IoC container
 *                  as a source of bean definitions
 */
@Configuration
public class BusinessLogicConfig {
    /**
     * @Bean - tells Spring that this method will return an object that should be registered
     *         as a bean in Spring Application Context
     *       - initMethod - calls initialization() before/during creation of Bean
     *       - destroyMethod - calls destruction() before destruction of Bean
     * @Scope - singleton - is default
     *        - prototype - completely new Bean each time its "autowired"
     * @return - the Bean
     */
    @Bean (initMethod = "initialization", destroyMethod = "destruction")
    //@Scope ("prototype")
    public BeanExample beanExample() {
        return new BeanExample();
    }
}
