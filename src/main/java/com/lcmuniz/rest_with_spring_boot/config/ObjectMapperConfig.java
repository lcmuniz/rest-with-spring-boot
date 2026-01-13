package com.lcmuniz.rest_with_spring_boot.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ObjectMapperConfig {

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        SimpleFilterProvider provider = new SimpleFilterProvider();
        provider.addFilter("NoSensitiveData", SimpleBeanPropertyFilter.serializeAllExcept("password"));
        mapper.setFilterProvider(provider);
        return mapper;
    }
}
