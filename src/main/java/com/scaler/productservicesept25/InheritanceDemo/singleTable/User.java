package com.scaler.productservicesept25.InheritanceDemo.singleTable;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "st_user")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name = "userType",
        discriminatorType = DiscriminatorType.INTEGER
)
@DiscriminatorValue(value = "0")
public class User {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Integer phoneNumber;
}
