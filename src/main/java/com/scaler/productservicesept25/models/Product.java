package com.scaler.productservicesept25.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "products")
public class Product extends BaseModel{
    private String title;
    private Double price;
    private String description;
    private String imgUrl;

    @ManyToOne
    private Category category;
}
