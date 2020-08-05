package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers() {
        List<UsersResponse> users = new ArrayList() {{
            add(new UsersResponse(1, "User 1"));
            add(new UsersResponse(2, "User 2"));
        }};
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
