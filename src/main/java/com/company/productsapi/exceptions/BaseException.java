package com.company.productsapi.exceptions;

import java.util.function.Supplier;

public interface BaseException extends Supplier {

    String getCode();
    String getDescription();
}
