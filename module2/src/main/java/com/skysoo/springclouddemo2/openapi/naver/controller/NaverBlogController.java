package com.skysoo.springclouddemo2.openapi.naver.controller;

import com.skysoo.springclouddemo2.openapi.naver.service.NaverBlogService;
import com.skysoo.springclouddemo2.openapi.naver.response.ResponseNaverBlog;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class NaverBlogController {

    private final NaverBlogService naverBlogService;

    public NaverBlogController(NaverBlogService naverBlogService) {
        this.naverBlogService = naverBlogService;
    }

    @GetMapping("blog")
    public ResponseNaverBlog findBlogByQuery(){
        return naverBlogService.findBlogByQuery("스프링부트");
    }

    @Deprecated
    @GetMapping("legacy-blog")
    public ResponseNaverBlog legacyFindBlogByQuery(){
        return naverBlogService.legacyFindBlogByQuery("스프링부트");
    }

}