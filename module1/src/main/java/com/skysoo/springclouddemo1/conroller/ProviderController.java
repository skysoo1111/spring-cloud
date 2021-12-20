package com.skysoo.springclouddemo1.conroller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/provider", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProviderController {
    @GetMapping("/member/{id}")
    public String member(@PathVariable("id") int id) {
        System.out.println(id);
        String memberName = "Jayden";
        return memberName;
    }
}
