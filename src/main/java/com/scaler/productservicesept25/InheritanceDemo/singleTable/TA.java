package com.scaler.productservicesept25.InheritanceDemo.singleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "st_TA")
@DiscriminatorValue(value = "1")
public class TA extends User {
    private Integer numberOfHelpRequestsHandled;
    private Double rating;
}
