package com.scaler.productservicesept25.controllerAdvice;

import com.scaler.productservicesept25.dtos.ExceptionDto;
import com.scaler.productservicesept25.dtos.ProductNotFoundExceptionDto;
import com.scaler.productservicesept25.exceptions.ProductNotFoundExceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductServiceExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionDto> handleRuntimeException(){

        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage("Something went wrong");
        exceptionDto.setResolutionDetails("Pay more now");

        return new ResponseEntity<>(exceptionDto,HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(ProductNotFoundExceptions.class)
    public ResponseEntity<ProductNotFoundExceptionDto> handleProductNotFoundException(ProductNotFoundExceptions ex){
        ProductNotFoundExceptionDto productNotFoundExceptionDto = new ProductNotFoundExceptionDto();
        productNotFoundExceptionDto.setProductId(ex.getProductId());
        productNotFoundExceptionDto.setMessage(ex.getMessage());
        productNotFoundExceptionDto.setResolutionDetails("Check the product id");
        return new ResponseEntity<>(productNotFoundExceptionDto,HttpStatus.NOT_FOUND);
    }
}
