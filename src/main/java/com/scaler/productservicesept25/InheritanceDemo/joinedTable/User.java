package com.scaler.productservicesept25.InheritanceDemo.joinedTable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "JT_Users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Integer phoneNumber;
}
