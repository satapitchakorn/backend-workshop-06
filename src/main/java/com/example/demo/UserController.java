package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers(@RequestParam(required = false, defaultValue = "1") String page, @RequestParam(value = "item_per_page", required = false, defaultValue = "10") String ipp) {

        List<UsersResponse> users = new ArrayList() {{
            add(new UsersResponse(1, "User 1"));
            add(new UsersResponse(2, "User 2"));
        }};
        UserPage up = new UserPage();
        up.setPage(Integer.parseInt(page));
        up.setItem_per_page(Integer.parseInt(ipp));
        return new ResponseEntity<>(up, HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id) {
        return new ResponseEntity<>(new UsersResponse(id, "User " + id), HttpStatus.OK);
    }
}
