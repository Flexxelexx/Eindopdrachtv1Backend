package com.example.eindopdrachtbackendv1.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;


import java.util.Collection;
import java.util.Date;

@Entity
public class Upload {

    @Id
    @GeneratedValue
    private Long id;
    //
    //Fish class van maken;
    @Column
    private double weightFish;
    @Column
    private double lengthFish;
    @Column
    private String charsFish;
    @Column
    private String speciesFish;
    @Column
    private String photoFish;
    //
    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy@mm:ss")
    private Date timeCaughtFish;

    //Aanpassen naar many to one mappen op user_id
//    @ManyToOne (fetch = FetchType.EAGER)
//    private User user;


}
