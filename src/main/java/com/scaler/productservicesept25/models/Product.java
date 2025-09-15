package com.scaler.productservicesept25.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "products")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Product extends BaseModel {
    private String title;
    private Double price;
    private String description;
    private String imageUrl;

    //@ManyToOne
    //@ManyToOne(cascade = {jakarta.persistence.CascadeType.PERSIST})
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Category category;
}
