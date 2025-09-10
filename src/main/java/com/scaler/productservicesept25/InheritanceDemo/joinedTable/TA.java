package com.scaler.productservicesept25.InheritanceDemo.joinedTable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "JT_TA")
@PrimaryKeyJoinColumn(name = "ta_id")
public class TA extends User {
    private Integer numberOfHelpRequestsHandled;
    private Double rating;
}
