package com.example.eindopdrachtbackendv1.models;

import jdk.jfr.DataAmount;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import java.time.LocalDate;
import java.util.Collection;
import java.util.function.Function;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(name = "users")
public class User {

    @Id
    private Long id;

    @Column
    private String username;

    @Column
    @NotBlank
    @Size(min = 6)
    private String password;
    @Column
    @Email
    private String email;
    @Column
    private LocalDate dob;

    //Roles komt later wel
//    @ManyToMany(fetch = FetchType.EAGER)
//    private Collection<Role> roles;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<FishingSpot> fishingSpots;


}
