package com.example.finalspringfx.Models;



import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Document(collection = "Users")
public class User {

    private String password;
    private String username;
    private String firstName;
    private String lastName;


    public User(String firstName, String lastName, String username, String password) {
        this.password = password;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User() {

    }




}
