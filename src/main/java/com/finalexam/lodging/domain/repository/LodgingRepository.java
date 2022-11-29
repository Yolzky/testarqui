package com.finalexam.lodging.domain.repository;

import com.finalexam.lodging.domain.model.Lodging;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;

@Repository
public interface LodgingRepository extends JpaRepository<Lodging, Long> {
    public Page<Lodging> findById(Long Id, Pageable pageable); //esto es para mostrarlo como paginación, lo pongo como ejemplo y por si es necesario
}
