package com.project.hotel.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Room {

    @Id
    private String roomId;

    @Column(nullable = false)
    private Integer maxAmountOfBeds;

    @Column(nullable = false)
    private Double pricePerNight;

    @Column(nullable = false)
    private Double priceForFood;

    @Column(unique = true, nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Type type;

    @Column(nullable = false)
    private String description;

}

