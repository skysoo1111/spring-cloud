package com.skysoo.springclouddemo2.openapi.naver.configuration;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "naver.openapi")
public class NaverOpenAPIProperties {
    private String clientId;
    private String clientSecret;
}
