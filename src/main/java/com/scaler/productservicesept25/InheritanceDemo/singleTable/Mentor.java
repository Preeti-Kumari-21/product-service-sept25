package com.scaler.productservicesept25.InheritanceDemo.singleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "st_Mentor")
@DiscriminatorValue(value = "2")
public class Mentor extends User {
    private String companyName;
    private Integer yearsOfExperience;
}
