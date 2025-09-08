package com.scaler.productservicesept25.InheritanceDemo.tablePerClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "TPC_MENTOR")
public class Mentor extends User {
    private String companyName;
    private Integer yearsOfExperience;
}
