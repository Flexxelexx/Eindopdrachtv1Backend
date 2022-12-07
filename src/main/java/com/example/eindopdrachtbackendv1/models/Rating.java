package com.example.eindopdrachtbackendv1.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(name = "ratings")
public class Rating {

    @Id
    @GeneratedValue
    private Long id;

    @Min(0) @Max(5)
    private double StarCount;

    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy@mm:ss")
    private Date timeStamp;


}
