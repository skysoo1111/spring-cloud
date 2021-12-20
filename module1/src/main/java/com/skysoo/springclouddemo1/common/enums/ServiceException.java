package com.skysoo.springclouddemo1.common.enums;

import lombok.Getter;

@Getter
public enum ServiceException {
    OK("200","OK"),
    NOT_FOUND("404","NOT_FOUND");

    ServiceException(String code, String message) {
        this.code = code;
        this.message = message;
    }

    private String code;
    private String message;
}
