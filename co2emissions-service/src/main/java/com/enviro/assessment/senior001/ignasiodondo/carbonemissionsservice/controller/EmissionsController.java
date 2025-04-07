package com.enviro.assessment.senior001.ignasiodondo.carbonemissionsservice.controller;

import com.enviro.assessment.senior001.ignasiodondo.carbonemissionsservice.dto.EmissionRequestDTO;
import com.enviro.assessment.senior001.ignasiodondo.carbonemissionsservice.dto.EmissionResponseDTO;
import com.enviro.assessment.senior001.ignasiodondo.carbonemissionsservice.service.EmissionsService;
import com.enviro.assessment.senior001.ignasiodondo.carbonemissionsservice.validators.CreateEmissionValidationGroup;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.groups.Default;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/emissions")
@Tag(name = "Emissions", description = "API for managing Emissions")
public class EmissionsController {
    private final EmissionsService emissionsService;

    public EmissionsController(EmissionsService emissionsService) {
        this.emissionsService = emissionsService;
    }

    @GetMapping
    @Operation(summary = "Get Emissions")
    public ResponseEntity<List<EmissionResponseDTO>> getPatients() {
        List<EmissionResponseDTO> patients =emissionsService.getEmissions();
        return ResponseEntity.ok().body(patients);
    }

    @PostMapping
    @Operation(summary = "Create a new Emission entry")
    public ResponseEntity<EmissionResponseDTO> createPatient(
            @Validated({Default.class, CreateEmissionValidationGroup.class})
            @RequestBody EmissionRequestDTO patientRequestDTO) {

        EmissionResponseDTO patientResponseDTO = emissionsService.createEmission(
                patientRequestDTO);

        return ResponseEntity.ok().body(patientResponseDTO);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a new Patient")
    public ResponseEntity<EmissionResponseDTO> updatePatient(@PathVariable UUID id,
                                                            @Validated({Default.class}) @RequestBody EmissionRequestDTO emissionRequestDTO) {

        EmissionResponseDTO emissionResponseDTO = emissionsService.updateEmission(id,
                emissionRequestDTO);

        return ResponseEntity.ok().body(emissionResponseDTO);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a Patient")
    public ResponseEntity<Void> deletePatient(@PathVariable UUID id) {
        emissionsService.deletePatient(id);
        return ResponseEntity.noContent().build();
    }
}
