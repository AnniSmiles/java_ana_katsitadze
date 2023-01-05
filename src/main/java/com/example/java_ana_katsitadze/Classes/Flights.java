package com.example.java_ana_katsitadze.Classes;

import java.util.Date;
import lombok.*;
@Getter @Setter @AllArgsConstructor @NoArgsConstructor

public class Flights {
    private long id;
    private String direction;
    private Date flightDate;
    private int price;
    private String startCity;
    private int places;

    public Flights(String direction,Date flightDate,int price,String startCity,int places){
        this.direction = direction;
        this.flightDate = flightDate;
        this.price=price;
        this.startCity = startCity;
        this.places = places;
    }



}
