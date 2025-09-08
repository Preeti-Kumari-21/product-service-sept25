package com.scaler.productservicesept25.InheritanceDemo.tablePerClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "TPC_TA")
public class TA extends User {
    private Integer numberOfHelpRequestsHandled;
    private Double rating;
}
