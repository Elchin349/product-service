package com.company.productsapi.exceptions;

import com.company.productsapi.enums.BusinessStatus;
import org.springframework.http.HttpStatus;

import java.util.function.Supplier;

public class NotFoundException extends BaseApiRuntimeException  {

    private static final long serialVersionUID = -4719158337863765906L;


    public NotFoundException(String message, HttpStatus status, String description, String reason) {
        super(message, status.toString(), description, reason);
    }

    public NotFoundException(BusinessStatus businessStatus, Object... params) {
        super(businessStatus.getMessage(params), businessStatus.getCode(), businessStatus.getReason(params), businessStatus.getDescription(params));
    }
}
