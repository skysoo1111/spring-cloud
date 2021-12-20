package com.skysoo.springclouddemo2.openapi.naver.naveropenfeign;

import com.skysoo.springclouddemo2.openapi.naver.response.NaverOpenAPIClientFallbackFactory;
import com.skysoo.springclouddemo2.openapi.naver.response.ResponseNaverBlog;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "naver-open-api"
            ,url = "${naver.openapi.url}"
//            ,fallback = NaverOpenAPIClientFallback.class
            ,fallbackFactory = NaverOpenAPIClientFallbackFactory.class)
public interface NaverOpenAPIClient {
    @RequestMapping(method = RequestMethod.GET,
            value = "/v1/search/blog.json",
            produces = "application/json")
    ResponseNaverBlog findBlogByQuery(@RequestHeader("X-Naver-Client-Id") String clientId,
                                      @RequestHeader("X-Naver-Client-Secret") String clientSecret,
                                      @RequestParam(name = "query") String query);
}
