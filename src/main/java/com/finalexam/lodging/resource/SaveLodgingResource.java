package com.finalexam.lodging.resource;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SaveLodgingResource {

    private Long passengerId;

    private String lodgeName;

    private String lodgeAddres;

    private Long lodgeCost;

    private String dateArrival;

    private String dateLeave;
}
