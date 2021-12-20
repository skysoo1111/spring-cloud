package com.skysoo.springclouddemo2.openapi.naver.response;

import com.skysoo.springclouddemo2.openapi.naver.naveropenfeign.NaverOpenAPIClient;

//@Component
public class NaverOpenAPIClientFallback implements NaverOpenAPIClient {
    @Override
    public ResponseNaverBlog findBlogByQuery(String clientId, String clientSecret, String query) {
        return ResponseNaverBlog.EMPTY;
    }
}
