package com.example.cepfinder.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket cepFinder(){
      return new Docket(DocumentationType.SWAGGER_2)
              .select()
              .apis(RequestHandlerSelectors.basePackage("com.example.cepfinder.controller"))
              .paths(PathSelectors.any())
              .build()
              .apiInfo(metaInfo());
    };

    private ApiInfo metaInfo(){
      ApiInfo apiInfo = new ApiInfo(
              "CepFinder",
              "API REST de consulta de fretes por CEP utilizando viacep",
              "1.0",
              "Terms of Service",
              new Contact("Levi Rios Gomes", "https://github.com/LeviG99", "leviriosgomes@gmail.com"),
              "Apache License Version 2.0",
              "https://wwww.apache.org/licensen.html", new ArrayList<VendorExtension>()
      );

      return apiInfo;
    };
}
