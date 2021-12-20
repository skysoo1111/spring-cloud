package com.skysoo.springclouddemo2.customapi.controller;

import com.skysoo.springclouddemo2.customapi.feigninterface.ConsumerClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/consumer", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class ConsumerController {
    private final ConsumerClient consumerClient;

    @GetMapping("/getMemberName/{id}")
    public String getMemberName(@PathVariable("id") int id) {
        return consumerClient.member(id);
    }
}
