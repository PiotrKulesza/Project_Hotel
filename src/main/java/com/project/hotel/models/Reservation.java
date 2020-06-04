package com.project.hotel.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.jws.soap.SOAPBinding;
import javax.persistence.Column;
import javax.persistence.OneToOne;
import java.util.Date;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Reservation {

    @Id
    private String reservationId;

    @OneToOne
    @Column(nullable = false)
    private User user;

    @OneToOne
    @Column(nullable = false)
    private Room room;

    @Column(nullable = false)
    private Date startDate;

    @Column(nullable = false)
    private Date endtDate;

    @Column(nullable = false)
    private Double roomPrice;

    @Column(nullable = false)
    private Boolean foodIncluded;

    @Column()
    private Double foodPrice;

    @Column(nullable = false)
    private Double totalPrice;


}
