package com.skysoo.springclouddemo2.openapi.naver.service;

import com.skysoo.springclouddemo2.openapi.naver.naveropenfeign.NaverOpenAPIClient;
import com.skysoo.springclouddemo2.openapi.naver.configuration.NaverOpenAPIProperties;
import com.skysoo.springclouddemo2.openapi.naver.response.ResponseNaverBlog;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
@Configuration
@EnableConfigurationProperties({ NaverOpenAPIProperties.class })
@Log4j2
public class NaverBlogService {

    private final NaverOpenAPIProperties naverOpenAPIProperties;
    private final NaverOpenAPIClient naverOpenAPIClient;

    public NaverBlogService(NaverOpenAPIProperties naverOpenAPIProperties,
                            NaverOpenAPIClient naverOpenAPIClient) {
        this.naverOpenAPIProperties = naverOpenAPIProperties;
        this.naverOpenAPIClient = naverOpenAPIClient;
    }

    public ResponseNaverBlog findBlogByQuery(String query){
        return naverOpenAPIClient.findBlogByQuery(naverOpenAPIProperties.getClientId(),
                naverOpenAPIProperties.getClientSecret(),
                query);
    }

    @Deprecated
    public ResponseNaverBlog legacyFindBlogByQuery(String query){

        final String uri = "https://openapi.naver.com/v1/search/blog.json?query=" + query;

        //TODO:Bean 주입
        RestTemplate restTemplate = new RestTemplate();

        MultiValueMap<String, String> headerMap = new LinkedMultiValueMap<>();
        headerMap.add("X-Naver-Client-Id", naverOpenAPIProperties.getClientId());
        headerMap.add("X-Naver-Client-Secret", naverOpenAPIProperties.getClientSecret());
        headerMap.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<?> headers = new HttpEntity<>(headerMap);

        ResponseEntity<ResponseNaverBlog> responseEntity =
                restTemplate.exchange(uri, HttpMethod.GET, headers, ResponseNaverBlog.class);

        return responseEntity.getBody();
    }




}
