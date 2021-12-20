package com.skysoo.springclouddemo1.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DefaultResponse<T> {
    private String statusCode;
    private String responseMessage;
    private T data;

    @Builder
    public DefaultResponse(String statusCode, String responseMessage, T data) {
        this.statusCode = statusCode;
        this.responseMessage = responseMessage;
        this.data = data;
    }
}
