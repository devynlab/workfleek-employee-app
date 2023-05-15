package io.devynlab.employeeapp;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class EmployeeAppApplication {

  public static void main(String[] args) {
    SpringApplication.run(EmployeeAppApplication.class, args);
  }

  @Bean
  ModelMapper modelMapper() {
    return new ModelMapper();
  }

  @Bean
  RestTemplate restTemplate() {
    return new RestTemplate();
  }

}
