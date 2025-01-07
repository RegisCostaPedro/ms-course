package com.ms_course.hr_payroll.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    // Registrar uma instância única de um objeto do tipo RestTemplate,
    // para por fim, injetar em outros componentes
    // Padrão de projeto Singleton
    @Bean
    public RestTemplate restTemplate(){
    return new RestTemplate();
    }

}
