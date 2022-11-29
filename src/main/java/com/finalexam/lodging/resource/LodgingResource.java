package com.finalexam.lodging.resource;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LodgingResource {
    //private Long id;

    private Long passengerId;

    private String lodgeName;

    private String lodgeAddres;

    private Long lodgeCost;

    private String dateArrival;

    private String dateLeave;

    private Date createdAt;

    private Date updateAt;
}
