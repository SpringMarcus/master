package com.kibo.order.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan(basePackages = {
        "com.kibo.order.config.controller",
        "com.kibo.order.config.service",
        "com.kibo.order.config.data"})
public class AppConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        // create Property Configurer
        PropertySourcesPlaceholderConfigurer properties = new PropertySourcesPlaceholderConfigurer();

        // configurations
        properties.setIgnoreResourceNotFound(true);
        properties.setIgnoreUnresolvablePlaceholders(true);

        List<Resource> resources = new ArrayList<>();

        // standard properties
        resources.add(new ClassPathResource("properties/system/order.manager.properties"));

        // user defined properties (overrides standard properties)
        String userPropertiesPath = "properties/system/developer/" + System.getProperty("user.name") + "_order.manager.properties";
        ClassPathResource userProperties = new ClassPathResource(userPropertiesPath);
        if (userProperties.exists()) {
            resources.add(userProperties);
        }

        // add resources array to Property Configurer
        properties.setLocations(resources.toArray(new Resource[resources.size()]));

        return properties;
    }
}

