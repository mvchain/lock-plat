package com.mvc.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author qyc
 */
@EnableAutoConfiguration
@EnableEurekaClient
@EnableConfigServer
public class ConfigServerBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerBootstrap.class, args);
    }
}
