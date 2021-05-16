package com.company.productsapi.enums;

import org.springframework.http.HttpStatus;

public enum BusinessStatus {
    PRODUCT_BY_ID_NOT_FOUND("Product by id not found",HttpStatus.NOT_FOUND,"Id is not valid","Check id again")
    ;
    private final String message;
    private final HttpStatus code;
    private final String reason;
    private final String description;

    BusinessStatus(String message, HttpStatus code, String reason, String description) {
        this.message = message;
        this.code = code;
        this.reason = reason;
        this.description = description;
    }

    public String getMessage(Object... params) {
        return String.format(this.message,params);
    }

    public String getCode() {
        return this.code.toString();
    }

    public String getReason(Object... params) {
        return String.format(this.reason,params);
    }

    public String getDescription(Object... params) {
        return String.format(this.description,params);
    }

}
