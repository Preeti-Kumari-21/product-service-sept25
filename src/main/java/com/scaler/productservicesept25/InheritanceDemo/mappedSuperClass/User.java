package com.scaler.productservicesept25.InheritanceDemo.mappedSuperClass;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class User {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Integer phoneNumber;
}
