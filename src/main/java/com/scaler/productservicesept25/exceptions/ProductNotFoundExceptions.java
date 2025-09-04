package com.scaler.productservicesept25.exceptions;

import lombok.Getter;

@Getter
public class ProductNotFoundExceptions extends Exception{
    private final long productId;
    public ProductNotFoundExceptions(long productId) {
        super("Product with id " + productId + " not found");
        this.productId = productId;
    }
}
