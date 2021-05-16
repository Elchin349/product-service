package com.company.productsapi.exceptions;

public class BaseApiRuntimeException extends RuntimeException implements BaseException{
    private String code;
    private String description;
    private String reason;

    public BaseApiRuntimeException(String message, String code, String description, String reason) {
        super(message);
        this.code = code;
        this.description = description;
        this.reason = reason;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    public String getReason() {
        return reason;
    }

    @Override
    public Object get() {
        return null;
    }
}
