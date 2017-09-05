package com.example.config;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.fasterxml.jackson.databind.SerializationFeature;

@Configuration
@ComponentScan(basePackages={ "com.example.config" })
public class WebConfig extends WebMvcConfigurerAdapter{

	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		Optional<HttpMessageConverter<?>> convertedFound = converters.stream().filter(c -> c instanceof AbstractJackson2HttpMessageConverter).findFirst();
		if (convertedFound.isPresent()) {
			final AbstractJackson2HttpMessageConverter converter = (AbstractJackson2HttpMessageConverter) convertedFound.get();
			converter.getObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
			converter.getObjectMapper().enable(SerializationFeature.FAIL_ON_UNWRAPPED_TYPE_IDENTIFIERS);
		}
	}
	
	
}
