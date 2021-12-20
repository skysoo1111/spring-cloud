package com.skysoo.springclouddemo1.conroller;

import com.skysoo.springclouddemo1.common.enums.ServiceException;
import com.skysoo.springclouddemo1.response.DefaultResponse;
import com.skysoo.springclouddemo1.response.ResponseHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/provider", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class ProviderController {
    private final ResponseHandler responseHandler;

    @GetMapping("/member/{id}")
    public ResponseEntity<DefaultResponse<Object>> member(@PathVariable("id") int id) {
        System.out.println(id);
        switch (id) {
            case 555:
                String memberName = "Jayden";
                return ResponseEntity.ok()
                        .header("headers")
                        .body(responseHandler.create(memberName));
            default:
                return ResponseEntity.ok()
                        .body(responseHandler.create(String.valueOf(id)
                                ,ServiceException.NOT_FOUND.getCode()
                                ,ServiceException.NOT_FOUND.getMessage()));
        }
    }
}
