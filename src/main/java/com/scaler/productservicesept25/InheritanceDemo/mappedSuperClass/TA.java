package com.scaler.productservicesept25.InheritanceDemo.mappedSuperClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "superClass_TA")
public class TA extends User {
    private Integer numberOfHelpRequestsHandled;
    private Double rating;
}
