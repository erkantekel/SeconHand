package com.example.secondhand.controller;


import com.example.secondhand.model.User;
import com.example.secondhand.service.UserService;
import org.hibernate.sql.Update;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.secondhand.dto.*;
import java.util.List;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return ResponseEntity.of(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity <UserDto> getUserById(@PathVariable("id") Long id){
        return ResponseEntity.ok(userService.getUserById(id));
    }
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody CreateUserRequest userResquest){
        return ResponseEntity.ok(userService.createUser(userResquest));
    }
    @PutMapping("/{id}")
    ResponseEntity<UserDto> updateUser(@PathVariable Long id,
            @RequestBody UpdateUserRequest updateUserRequest){
        return ResponseEntity.ok(userService.updateUser(id , updateUserRequest));
    }
/*    @PatchMapping("/{id}")
    public ResponseEntity<Void> deactiveUser(@PathVariable ("id") Long id){
        userService.deactiveUser(id);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable ("id") Long id){
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }*/
}
