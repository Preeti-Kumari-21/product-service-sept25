package com.scaler.productservicesept25.exceptions;

import lombok.Getter;

@Getter
public class ProductNotFoundExceptions extends Exception {
    private long productId;

    public ProductNotFoundExceptions() {
        super("Product not found");
    }

    public ProductNotFoundExceptions(long productId) {
        super("Product with id " + productId + " not found");
        this.productId = productId;
    }

    public ProductNotFoundExceptions(String message) {
        super(message);
    }

    public ProductNotFoundExceptions(long productId, String message) {
        super(message);
        this.productId = productId;
    }

}
