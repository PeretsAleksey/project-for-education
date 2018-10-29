package com.perets.project.configuration;

import com.perets.project.service.ExtendedConversionService;
import com.perets.project.service.impl.ExtendedConversionServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

import java.util.List;

@Configuration
public class ConversionConfiguration {

    @Bean
    ExtendedConversionService extendedConversionService(List<Converter> converters) {
        ExtendedConversionServiceImpl extendedConversionService = new ExtendedConversionServiceImpl();
        converters.forEach(extendedConversionService::addConverter);
        return extendedConversionService;
    }
}
