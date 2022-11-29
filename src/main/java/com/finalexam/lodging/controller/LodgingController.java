package com.finalexam.lodging.controller;

import com.finalexam.lodging.domain.model.Lodging;
import com.finalexam.lodging.domain.service.LodgingService;
import com.finalexam.lodging.resource.LodgingResource;
import com.finalexam.lodging.resource.SaveLodgingResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.modelmapper.ModelMapper;
import javax.validation.Valid;
import io.swagger.v3.oas.annotations.Operation;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins="*")//esto es para los permisos del CORS
@RestController
@RequestMapping("/api/v1")
public class LodgingController {

    @Autowired
    private LodgingService lodgingService;

    @Autowired
    private ModelMapper mapper;

    private Lodging convertToEntity(SaveLodgingResource resource){
        return mapper.map(resource, Lodging.class);
    }
    private LodgingResource convertToResource(Lodging entity){
        return mapper.map(entity,LodgingResource.class);
    }
    @Operation(summary="Create Lodging", description="Create Lodging", tags={"lodging"})
    @PostMapping("/lodging")
    public LodgingResource createLodging(
            @Valid @RequestBody SaveLodgingResource resource){
        return convertToResource(lodgingService.createLodging(convertToEntity(resource)));
    }
    @Operation(summary="Delete lodging", description="Delete lodging", tags={"lodging"})
    @DeleteMapping("/lodging/{lodgingId}")
    public ResponseEntity<?>deleteLodging(
            @PathVariable Long lodgingId){
        return lodgingService.deleteLodging(lodgingId);
    }
    @Operation(summary="Update lodging", description="Update lodging", tags={"lodging"})
    @PutMapping("/lodging/{lodgingId}")
    public LodgingResource updateLodging(
            @PathVariable Long lodgingId,
            @Valid @RequestBody SaveLodgingResource resource){
        return convertToResource(lodgingService.updateLodging(lodgingId,convertToEntity(resource)));
    }
    @Operation(summary="Get lodging by passenger Id", description="Get lodging by passenger Id", tags={"lodging"})
    @GetMapping("/lodging/{passengerId}")
    public Page<LodgingResource> getAllLodgingsByPassengerId(
            @PathVariable Long passengerId,
            Pageable pageable){
        Page<Lodging> lodgingPage = lodgingService.getAllLodgingsByPassengerId(passengerId,pageable);
        List<LodgingResource> resources = lodgingPage.getContent().stream().map(this::convertToResource).collect(Collectors.toList());
        return new PageImpl<>(resources,pageable,resources.size());
    }
    @Operation(summary="Get lodging", description="Get lodging", tags={"lodging"})
    @GetMapping("/lodging")
    public Page<LodgingResource> getAllLodgings(Pageable pageable){
        Page<Lodging> lodgingPage = lodgingService.getAllLodgings(pageable);
        List<LodgingResource> resources = lodgingPage.getContent().stream().map(this::convertToResource).collect(Collectors.toList());
        return new PageImpl<>(resources,pageable,resources.size());
    }
}
