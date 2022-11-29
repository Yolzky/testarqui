package com.finalexam.lodging.domain.service;

import com.finalexam.lodging.domain.model.Lodging;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Pageable;

public interface LodgingService {
    //Realizaré un CRUD - Create Read Update Delete
    Lodging createLodging(Lodging lodging);
    Page<Lodging> getAllLodgingsByPassengerId(Long passengerId, Pageable pageable);
    Page<Lodging> getAllLodgings(Pageable pageable);
    Lodging updateLodging(Long lodgingId,Lodging lodging);
    ResponseEntity<?> deleteLodging(Long lodgingId);
}
