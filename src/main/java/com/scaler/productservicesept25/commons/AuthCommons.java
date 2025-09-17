package com.scaler.productservicesept25.commons;

import com.scaler.productservicesept25.dtos.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AuthCommons {

    private RestTemplate restTemplate;

    public AuthCommons(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public UserDto validateToken(String tokenValue){

        String url = "http://localhost:2000/auth/validate/{tokenValue}";
        ResponseEntity<UserDto> response = restTemplate.getForEntity(url,
            UserDto.class,tokenValue
        );
        return response.getBody();
    }
}
