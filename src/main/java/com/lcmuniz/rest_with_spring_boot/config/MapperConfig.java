package com.lcmuniz.rest_with_spring_boot.config;

import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

   @Bean
    public Jackson2ObjectMapperBuilderCustomizer filtersCustomizer() {
        return builder -> builder.filters(new SimpleFilterProvider()
                .addFilter("NoSensitiveData",
                        SimpleBeanPropertyFilter.serializeAllExcept("password"))
                .setFailOnUnknownId(false)
        );
    }

}
