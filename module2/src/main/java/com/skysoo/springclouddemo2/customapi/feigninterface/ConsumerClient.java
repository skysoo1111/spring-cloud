package com.skysoo.springclouddemo2.customapi.feigninterface;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "member-client", url = "localhost:8881/api/v1/provider")
public interface ConsumerClient {

    @GetMapping(value = "/member/{id}")
    String member(@PathVariable("id") int id);
}
