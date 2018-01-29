package com.coalvalue.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
  class RestTemplateConfiguration {
    private String checkTokenUrl;


    @Bean
    public RestTemplate restTemplate() {


        RestTemplate restTemplate = new RestTemplate();

        return restTemplate;
    }

    }
