package com.example.demo.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers(@RequestParam(required = false, defaultValue = "1") int page,
                                         @RequestParam(value = "item_per_page", required = false, defaultValue = "10") int ipp) {

        List<User> users = new ArrayList() {{
            add(new User(1, "User 1"));
            add(new User(2, "User 2"));
        }};
        UserPage up = new UserPage();
        up.setPage(page);
        up.setItemPerPage(ipp);
        up.setUsers(users);
        return new ResponseEntity<>(up, HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id) {
        return new ResponseEntity<>(new User(id, "User " + id), HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<?> create(@RequestBody User user) {
        return new ResponseEntity<>(userRepository.save(user), HttpStatus.OK);
    }
}
