package com.example.cepfinder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class CepFinderApplication {

    public static void main(String[] args) {
        SpringApplication.run(CepFinderApplication.class, args);
    }

}
