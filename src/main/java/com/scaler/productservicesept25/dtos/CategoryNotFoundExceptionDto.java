package com.scaler.productservicesept25.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryNotFoundExceptionDto {
    private String message;
    private String resolutionDetails;
}
