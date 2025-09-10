package com.scaler.productservicesept25.InheritanceDemo.joinedTable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "JT_instructors")
@PrimaryKeyJoinColumn(name = "instructor_id")
public class Instructor extends User {
    private String subjectExpertise;
    private Double rating;
}
