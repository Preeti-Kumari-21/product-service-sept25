package com.scaler.productservicesept25.InheritanceDemo.joinedTable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "JT_Mentors")
@PrimaryKeyJoinColumn(name = "mentor_id")
public class Mentor extends User {
    private String companyName;
    private Integer yearsOfExperience;
}
