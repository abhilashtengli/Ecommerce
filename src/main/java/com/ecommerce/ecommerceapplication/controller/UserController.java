package com.ecommerce.ecommerceapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ecommerce.ecommerceapplication.dto.UserDto;
import com.ecommerce.ecommerceapplication.exceptionClass.UserNotFoundException;
import com.ecommerce.ecommerceapplication.mapper.UserMapper;
import com.ecommerce.ecommerceapplication.model.JwtRequest;
import com.ecommerce.ecommerceapplication.model.JwtResponse;
import com.ecommerce.ecommerceapplication.model.User;
import com.ecommerce.ecommerceapplication.security.JwtHelper;
import com.ecommerce.ecommerceapplication.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private JwtHelper helper;

    @PostMapping("save")
    public ResponseEntity<UserDto> saveUser(@Valid @RequestBody UserDto user) {
        User newUser = userMapper.saveUser(user);
        User savedUser = userService.saveNewUser(newUser);
        UserDto userDto = userMapper.convertToUserToUserDto(savedUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(userDto);
    }

    @GetMapping("/get/id/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Integer id) throws UserNotFoundException {
        User user = userService.getById(id);
        UserDto userDto = userMapper.convertToUserToUserDto(user);
        return ResponseEntity.status(HttpStatus.OK).body(userDto);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Integer id, @RequestBody UserDto userDto)
            throws UserNotFoundException {
        User user = userMapper.updateUser(userDto);
        User updatedUser = userService.updateUser(user, id);
        UserDto userDto1 = userMapper.convertToUserToUserDto(updatedUser);
        return ResponseEntity.status(HttpStatus.OK).body(userDto1);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request) {
        this.doAuthenticate(request.getEmail(), request.getPassword());
        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());
        String token = this.helper.generateToken(userDetails);
        JwtResponse response = JwtResponse.builder()
                .jwtToken(token)
                .userName(userDetails.getUsername()).build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private void doAuthenticate(String email, String password) {
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, password);
        try {
            manager.authenticate(authentication);
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException(" Invalid Username or Password  !!");
        }
    }

    @ExceptionHandler(BadCredentialsException.class)
    public String exceptionHandler() {
        return "Credentials Invalid !!";
    }

}
