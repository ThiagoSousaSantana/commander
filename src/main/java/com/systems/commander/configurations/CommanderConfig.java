package com.systems.commander.configurations;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommanderConfig {

  @Bean
  public ModelMapper modelMapper() {
    return new ModelMapper();
  }
}
