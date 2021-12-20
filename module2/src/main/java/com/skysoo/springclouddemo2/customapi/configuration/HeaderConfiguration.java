package com.skysoo.springclouddemo2.customapi.configuration;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;

public class HeaderConfiguration {
    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> requestTemplate.header("header1", "header2", "header3");
    }
}
