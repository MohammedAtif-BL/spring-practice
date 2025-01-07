package com.example.user.controller;

import com.example.user.dto.UserDTO;
import com.example.user.model.User;
import com.example.user.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@Controller
//@ResponseBody
@Slf4j
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class MyController {

    private UserService userService;

    public MyController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "Hello World";
    }

    @RequestMapping(value = "/hello2/{name}", method = RequestMethod.GET)
    public String hello2(@PathVariable String name,@RequestParam String name2) {
        return "Welcome to Spring Demo " + name + " " + name2;
    }

    @RequestMapping(value = "/hello3", method = RequestMethod.GET)
    public String hello3(
            @RequestParam(defaultValue = "Request Param Needed") String name,
            @RequestParam(defaultValue = "Request Param Needed") String name2
    ) {
        return "Welcome to Request Param demo " + name + " " + name2;
    }

//    @RequestMapping(value = "/hello4", method = RequestMethod.POST)
    @PostMapping("/add")
    public ResponseEntity<UserDTO> hello4(@Valid @RequestBody UserDTO userDTO) {
//        log.info("Log message info level");
        return new ResponseEntity<>(userService.addUser(userDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

}
