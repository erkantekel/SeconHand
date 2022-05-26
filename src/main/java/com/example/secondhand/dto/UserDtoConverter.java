package com.example.secondhand.dto;

import com.example.secondhand.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserDtoConverter {

    public UserDto convert (User from){
        return new UserDto(from.getMail(), from.getFirstName(), from.getMiddleName(), from.getLastName());
    }
}
