package com.example.demo.users;

import lombok.Data;

@Data
public class UsersResponse {
    private int id;

    private String name;

    private int age;

    public UsersResponse(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
