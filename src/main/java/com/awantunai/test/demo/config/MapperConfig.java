package com.awantunai.test.demo.config;

import com.awantunai.test.demo.dto.mapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {


    @Bean
    public ModelMapper initModelMapper(){
        return new ModelMapper();
    }
}
