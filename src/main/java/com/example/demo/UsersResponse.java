package com.example.demo;

import lombok.Data;

@Data
public class UsersResponse {
    private int id;

    private String name;

    public UsersResponse(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
