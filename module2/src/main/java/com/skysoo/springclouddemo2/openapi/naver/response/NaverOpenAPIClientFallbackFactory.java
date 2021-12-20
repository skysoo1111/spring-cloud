package com.skysoo.springclouddemo2.openapi.naver.response;

import com.skysoo.springclouddemo2.openapi.naver.naveropenfeign.NaverOpenAPIClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class NaverOpenAPIClientFallbackFactory implements FallbackFactory<NaverOpenAPIClient> {

    @Override
    public NaverOpenAPIClient create(Throwable cause) {
        return (clientId, clientSecret, query) -> {
            log.error(cause.toString());
            return ResponseNaverBlog.EMPTY;
        };
    }
}