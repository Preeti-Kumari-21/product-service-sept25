package com.scaler.productservicesept25.controllerAdvice;

import com.scaler.productservicesept25.dtos.CategoryNotFoundExceptionDto;
import com.scaler.productservicesept25.dtos.ExceptionDto;
import com.scaler.productservicesept25.dtos.ProductNotFoundExceptionDto;
import com.scaler.productservicesept25.exceptions.CategoryNotFoundException;
import com.scaler.productservicesept25.exceptions.ProductNotFoundExceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.PrintWriter;
import java.io.StringWriter;

@ControllerAdvice
public class ProductServiceExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionDto> handleRuntimeException(RuntimeException ex){

        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage(ex.getMessage());

        //convert stack trace to string
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);
        String stackTrace = sw.toString();
        exceptionDto.setResolutionDetails(stackTrace);

        return new ResponseEntity<>(exceptionDto,HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(ProductNotFoundExceptions.class)
    public ResponseEntity<ProductNotFoundExceptionDto> handleProductNotFoundException(ProductNotFoundExceptions ex){
        ProductNotFoundExceptionDto productNotFoundExceptionDto = new ProductNotFoundExceptionDto();

        productNotFoundExceptionDto.setProductId(ex.getProductId());
        productNotFoundExceptionDto.setMessage(ex.getMessage());

        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);
        String stackTrace = sw.toString();
        productNotFoundExceptionDto.setResolutionDetails(stackTrace);

        return new ResponseEntity<>(productNotFoundExceptionDto,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<CategoryNotFoundExceptionDto> handleCategoryNotFoundException(CategoryNotFoundException ex){
        CategoryNotFoundExceptionDto categoryNotFoundExceptionDto = new CategoryNotFoundExceptionDto();
        categoryNotFoundExceptionDto.setMessage(ex.getMessage());

        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);
        String stackTrace = sw.toString();
        categoryNotFoundExceptionDto.setResolutionDetails(stackTrace);

        return new ResponseEntity<>(categoryNotFoundExceptionDto,HttpStatus.NOT_FOUND);
    }
}
