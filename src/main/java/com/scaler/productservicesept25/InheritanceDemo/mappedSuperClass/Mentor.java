package com.scaler.productservicesept25.InheritanceDemo.mappedSuperClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "superClass_Mentor")
public class Mentor extends User {
    private String companyName;
    private Integer yearsOfExperience;
}
