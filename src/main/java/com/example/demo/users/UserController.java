package com.example.demo.users;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class UserController {
    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers(@RequestParam(required = false, defaultValue = "1") int page,
                                         @RequestParam(value = "item_per_page", required = false, defaultValue = "10") int ipp) {

        List<UsersResponse> users = new ArrayList() {{
            add(new UsersResponse(1, "User 1"));
            add(new UsersResponse(2, "User 2"));
        }};
        UserPage up = new UserPage();
        up.setPage(page);
        up.setItemPerPage(ipp);
        up.setUsers(users);
        return new ResponseEntity<>(up, HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id) {
        return new ResponseEntity<>(new UsersResponse(id, "User " + id), HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<?> create(@RequestBody UsersResponse user) {
        Random ran = new Random();
        user.setId(ran.nextInt(1_000));
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
