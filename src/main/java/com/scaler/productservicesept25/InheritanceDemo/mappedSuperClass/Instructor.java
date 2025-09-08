package com.scaler.productservicesept25.InheritanceDemo.mappedSuperClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "superClass_Instructor")
public class Instructor extends User{
    private String subjectExpertise;
    private Double rating;
}
