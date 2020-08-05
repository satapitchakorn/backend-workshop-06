package com.example.demo.users;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class UserPage {
    private int page;

    @JsonProperty("item_per_page")
    private int itemPerPage;

    private List<User> users;
}
