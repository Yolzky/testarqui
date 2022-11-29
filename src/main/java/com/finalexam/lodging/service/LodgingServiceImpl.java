package com.finalexam.lodging.service;

import com.finalexam.lodging.domain.model.Lodging;
import com.finalexam.lodging.domain.repository.LodgingRepository;
import com.finalexam.lodging.domain.service.LodgingService;
import com.finalexam.lodging.exception.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;


@Service
@Slf4j
public class LodgingServiceImpl implements LodgingService {

    @Autowired
    private LodgingRepository lodgingRepository;

    public LodgingServiceImpl(LodgingRepository lodgingRepository){
        this.lodgingRepository=lodgingRepository;
    }

    @Override
    public Lodging createLodging(Lodging lodging) {
        return lodgingRepository.save(lodging);
    }

    @Override
    public Page<Lodging> getAllLodgingsByPassengerId(Long passengerId, Pageable pageable) {
        return lodgingRepository.findById(passengerId,pageable);
    }

    @Override
    public Page<Lodging> getAllLodgings(Pageable pageable) {
        return lodgingRepository.findAll(pageable);
    }

    @Override
    public Lodging updateLodging(Long lodgingId, Lodging lodgingRequest) {
        return lodgingRepository.findById(lodgingId).map(lodging->{
            lodging.setDateArrival(lodgingRequest.getDateArrival());
            lodging.setDateLeave(lodgingRequest.getDateLeave());
            return lodgingRepository.save(lodging);
        }).orElseThrow(()->new ResourceNotFoundException("Lodging"," Id",lodgingId)); //TODO resource not found Exception
    }

    @Override
    public ResponseEntity<?> deleteLodging(Long lodgingId) {
        return lodgingRepository.findById(lodgingId).map(lodging->{
            lodgingRepository.delete(lodging);
            return ResponseEntity.ok().build();
        }).orElseThrow(()->new ResourceNotFoundException("Lodging", "Id", lodgingId));//TODO resource not found Exception

    }
}
