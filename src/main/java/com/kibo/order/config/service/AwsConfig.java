package com.kibo.order.config.service;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Slf4j
@Configuration
public class AwsConfig {

    @Value("${aws.auth.accessKey}")
    private String accessKey;

    @Value("${aws.auth.secretKey}")
    private String secretKey;

    @PostConstruct
    public void status() {
        log.debug("AwsConfig loaded");
    }

    @Bean
    public AmazonS3 amazonS3() {
        BasicAWSCredentials awsCredentials = new BasicAWSCredentials(accessKey, secretKey);
        return new AmazonS3Client(awsCredentials);
    }
}
