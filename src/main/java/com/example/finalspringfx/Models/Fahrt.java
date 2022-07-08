package com.example.finalspringfx.Models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "Fahrtkosten")
public class Fahrt {

    private String minutes;
    private String seconds;
    private User user;
    private double price;
    private String date;

    public Fahrt(String minutes, String seconds, User user, double price, String date) {
        this.minutes = minutes;
        this.seconds = seconds;
        this.user = user;
        this.price = price;
        this.date = date;
    }

    public Fahrt(String minutes, String seconds, double price, String date) {
        this.minutes = minutes;
        this.seconds = seconds;
        this.price = price;
        this.date = date;
    }

    public Fahrt() {

    }
}
