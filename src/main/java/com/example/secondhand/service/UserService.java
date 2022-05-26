package com.example.secondhand.service;

import com.example.secondhand.dto.CreateUserRequest;
import com.example.secondhand.dto.UpdateUserRequest;
import com.example.secondhand.dto.UserDto;
import com.example.secondhand.dto.UserDtoConverter;
import com.example.secondhand.exception.UserNotFoundException;
import com.example.secondhand.model.User;
import com.example.secondhand.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserDtoConverter userDtoConverter;
    public UserService(UserRepository userRepository, UserDtoConverter userDtoConverter){
        this.userRepository=userRepository;
        this.userDtoConverter = userDtoConverter;
    }
    public List<UserDto> getAllUsers(){
        return userRepository.findAll().stream().map(userDtoConverter::convert).collect(Collectors.toList());
    }

    public UserDto getUserById(Long id) {
        User user = findByUserId(id);
        return null;
    }

    public UserDto createUser (CreateUserRequest userRequest){
        User user =new User(null,
                userRequest.getFirstName(),
                userRequest.getMail(),
                userRequest.getMiddleName(),
                userRequest.getLastName());

        return userDtoConverter.convert(userRepository.save(user));
    }

    public UserDto updateUser (Long id , UpdateUserRequest updateUserRequest){
        User user = findByUserId(id);
        User updatedUser = new User(user.getId(),
                user.getMail(),
                user.getMiddleName(),
                updateUserRequest.getFirstName(),
                user.getLastName());
        return userDtoConverter.convert(userRepository.save(updatedUser));
    }

    private User findByUserId(Long id){
        return userRepository.findById(id)
            .orElseThrow(() ->new UserNotFoundException("User couldn't be found by following id"));
    }

}
