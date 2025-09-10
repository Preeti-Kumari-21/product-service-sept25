package com.scaler.productservicesept25.dtos;

//import com.scaler.userservicesept25.models.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class UserDto {

    private Long id;

    private String name;

    private String email;

    //private List<Role> roles = new ArrayList<>();
}
