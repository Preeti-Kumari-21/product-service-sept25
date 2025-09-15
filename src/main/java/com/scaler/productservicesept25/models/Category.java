package com.scaler.productservicesept25.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "categories")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Category extends BaseModel {
    private String title;

    //@OneToMany(mappedBy = "category", cascade = CascadeType.REMOVE)
    @JsonBackReference
    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
