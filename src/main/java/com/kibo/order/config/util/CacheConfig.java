package com.kibo.order.config.util;

import lombok.extern.slf4j.Slf4j;
import net.spy.memcached.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.List;

@Slf4j
@Configuration
public class CacheConfig {

    @Value("${memcached.url}")
    private String address;

    @PostConstruct
    public void status() {
        log.debug("CacheConfig loaded");
    }

    @Bean(destroyMethod = "shutdown")
    public MemcachedClient memcachedClient() throws IOException {
        ConnectionFactoryBuilder connectionFactoryBuilder = new ConnectionFactoryBuilder();

        connectionFactoryBuilder.setProtocol(ConnectionFactoryBuilder.Protocol.BINARY);
        connectionFactoryBuilder.setOpTimeout(1000);
        connectionFactoryBuilder.setTimeoutExceptionThreshold(1998);
        connectionFactoryBuilder.setHashAlg(DefaultHashAlgorithm.KETAMA_HASH);
        connectionFactoryBuilder.setLocatorType(ConnectionFactoryBuilder.Locator.CONSISTENT);
        connectionFactoryBuilder.setFailureMode(FailureMode.Redistribute);
        connectionFactoryBuilder.setUseNagleAlgorithm(false);

        ConnectionFactory connectionFactory = connectionFactoryBuilder.build();
        List<InetSocketAddress> inetSocketAddresses = AddrUtil.getAddresses(address);

        return new MemcachedClient(connectionFactory, inetSocketAddresses);
    }
}