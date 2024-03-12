package com.hotel.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Entity
@Data
@Table(name = "hotel")
public class Hotel {
    @Id
    private String hotelId;
    private String name;
    private String location;
    private String about;
}
