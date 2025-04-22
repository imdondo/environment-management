package com.enviro.assessment.senior001.ignasiodondo.carbonemissionsservice.controller;

import com.enviro.assessment.senior001.ignasiodondo.carbonemissionsservice.dto.EmissionRequestDTO;
import com.enviro.assessment.senior001.ignasiodondo.carbonemissionsservice.dto.EmissionResponseDTO;
import com.enviro.assessment.senior001.ignasiodondo.carbonemissionsservice.service.EmissionsService;
import com.enviro.assessment.senior001.ignasiodondo.carbonemissionsservice.validators.CreateEmissionValidationGroup;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.groups.Default;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/emissions")
@Tag(name = "Emissions", description = "API for managing Emissions")
public class EmissionsController {
    private final EmissionsService emissionsService;

    public EmissionsController(EmissionsService emissionsService) {
        this.emissionsService = emissionsService;
    }

    @GetMapping
    @Operation(summary = "Get Emissions")
    public ResponseEntity<List<EmissionResponseDTO>> getEmissions() {
        List<EmissionResponseDTO> emissions = emissionsService.getEmissions();
        return ResponseEntity.ok().body(emissions);
    }

    @PostMapping
    @Operation(summary = "Create a new Emission entry")
    public ResponseEntity<EmissionResponseDTO> createEmission(
            @Validated({Default.class, CreateEmissionValidationGroup.class})
            @RequestBody EmissionRequestDTO emissionRequestDTO) {

        EmissionResponseDTO emissionResponseDTO = emissionsService.createEmission(
                emissionRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(emissionResponseDTO);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get an Emission by Id ")
    public ResponseEntity<EmissionResponseDTO> getEmissionById(@PathVariable UUID id) {

        EmissionResponseDTO emissionResponseDTO = emissionsService.getEmissionById(id);

        return ResponseEntity.ok().body(emissionResponseDTO);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a new Emission")
    public ResponseEntity<EmissionResponseDTO> updateEmission(@PathVariable UUID id,
                                                              @Validated({Default.class}) @RequestBody EmissionRequestDTO emissionRequestDTO) {

        EmissionResponseDTO emissionResponseDTO = emissionsService.updateEmission(id,
                emissionRequestDTO);

        return ResponseEntity.ok().body(emissionResponseDTO);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete an emission entry")
    public ResponseEntity<Void> deleteEmission(@PathVariable UUID id) {
        emissionsService.deleteEmission(id);
        return ResponseEntity.noContent().build();
    }
}
