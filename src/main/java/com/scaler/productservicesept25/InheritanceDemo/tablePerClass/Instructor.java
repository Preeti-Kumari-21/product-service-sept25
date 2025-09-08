package com.scaler.productservicesept25.InheritanceDemo.tablePerClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "TPC_INSTRUCTOR")
public class Instructor extends User {
    private String subjectExpertise;
    private Double rating;
}
