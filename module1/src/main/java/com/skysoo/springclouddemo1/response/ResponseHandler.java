package com.skysoo.springclouddemo1.response;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Component
public class ResponseHandler {
    private String code;
    private String message;
    private Object o;

    public DefaultResponse<Object> create(Object o) {
        return DefaultResponse.builder()
                .statusCode("200")
                .responseMessage("SUCCESS")
                .data(Optional.ofNullable(o))
                .build();
    }

    public DefaultResponse create(String code, String message) {
        return DefaultResponse.builder()
                .statusCode(code)
                .responseMessage(message)
                .build();
    }

    public DefaultResponse<Object> create(Object o, String code, String message) {
        return DefaultResponse.builder()
                .statusCode(code)
                .responseMessage(message)
                .data(Optional.ofNullable(o))
                .build();
    }
}
