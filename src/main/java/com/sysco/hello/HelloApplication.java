package com.sysco.hello;

import com.sysco.hello.config.WebProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
// @EnableCircuitBreaker
public class HelloApplication {

    @Autowired
    private WebProperties _webProperties;

    public static void main(String[] args) {
        SpringApplication.run(HelloApplication.class, args);
    }

    @Bean
    public CommandLineRunner run()
    {
        return args -> System.out.println( "Password = " + _webProperties.getPassword() );
    }

}
