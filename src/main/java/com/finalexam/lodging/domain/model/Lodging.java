package com.finalexam.lodging.domain.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "lodging")
public class Lodging {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long passengerId;

    private String lodgeName;

    private String lodgeAddres;

    private Long lodgeCost;

    private String dateArrival;

    private String dateLeave;

    private Date createdAt;

    private Date updateAt;
}
