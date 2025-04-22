package com.enviro.assessment.senior001.ignasiodondo.carbonemissionsservice.service;

import com.enviro.assessment.senior001.ignasiodondo.carbonemissionsservice.dto.EmissionRequestDTO;
import com.enviro.assessment.senior001.ignasiodondo.carbonemissionsservice.dto.CountryResponseDTO;
import com.enviro.assessment.senior001.ignasiodondo.carbonemissionsservice.dto.EmissionResponseDTO;
import com.enviro.assessment.senior001.ignasiodondo.carbonemissionsservice.exception.EmissionAlreadyExistsException;
import com.enviro.assessment.senior001.ignasiodondo.carbonemissionsservice.exception.EmissionNotFoundException;
import com.enviro.assessment.senior001.ignasiodondo.carbonemissionsservice.mapper.EmissionsMapper;
import com.enviro.assessment.senior001.ignasiodondo.carbonemissionsservice.model.Emissions;
import com.enviro.assessment.senior001.ignasiodondo.carbonemissionsservice.repository.EmissionsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmissionsService {

    private static final Logger log = LoggerFactory.getLogger(EmissionsService.class);
    private final EmissionsRepository emissionsRepository;

    public EmissionsService(EmissionsRepository emissionsRepository) {
        this.emissionsRepository = emissionsRepository;
    }

    public List<EmissionResponseDTO> getEmissions() {
        List<Emissions> emissions = emissionsRepository.findAll();

        return emissions.stream().map(EmissionsMapper::toDTO).toList();
    }

    public EmissionResponseDTO getEmissionById(UUID emissionId) {
        Optional<Emissions> optionalEmission = emissionsRepository.findById(emissionId);
        return optionalEmission.map(EmissionsMapper::toDTO).orElse(null);
    }

    public EmissionResponseDTO createEmission(EmissionRequestDTO emissionRequestDTO) {
        if (emissionsRepository.existsByEmissionYearAndCountryIdNot(emissionRequestDTO.getEmissionYear(), emissionRequestDTO.getCountryId())) {
            throw new EmissionAlreadyExistsException(
                    "A country with this emission " + "already exists"
                            + emissionRequestDTO.getEmissionYear() + " " + emissionRequestDTO.getCountryId());
        }

        Emissions newEmission = emissionsRepository.save(
                EmissionsMapper.toModel(emissionRequestDTO));
log.info("This is the emissionRequest {}", emissionRequestDTO);

        return EmissionsMapper.toDTO(newEmission);
    }

    public EmissionResponseDTO updateEmission(UUID id,
                                             EmissionRequestDTO emissionRequestDTO) {

        Emissions emissions = emissionsRepository.findById(id).orElseThrow(
                () -> new EmissionNotFoundException("Emission entry not found with ID: " + id));

        if (emissionsRepository.existsByEmissionYearAndCountryIdNot(emissionRequestDTO.getEmissionYear(), emissionRequestDTO.getCountryId())) {
            throw new EmissionAlreadyExistsException(
                    "An emission entry for this country for the year " + "already exists"
                            + emissionRequestDTO.getCountryId() + " " + emissionRequestDTO.getEmissionYear());
        }

        emissions.setEmissionYear(emissionRequestDTO.getEmissionYear());
        emissions.setTotalEmissions(Double.parseDouble(emissionRequestDTO.getTotalEmissions()));
        emissions.setCoalEmissions(Double.parseDouble(emissionRequestDTO.getCoalEmissions()));
        emissions.setOilEmissions(Double.parseDouble(emissionRequestDTO.getOilEmissions()));
        emissions.setGasEmissions(Double.parseDouble(emissionRequestDTO.getGasEmissions()));
        emissions.setCementEmissions(Double.parseDouble(emissionRequestDTO.getCementEmissions()));
        emissions.setCementEmissions(Double.parseDouble(emissionRequestDTO.getCementEmissions()));
        emissions.setFlaringEmissions(Double.parseDouble(emissionRequestDTO.getFlaringEmissions()));
        emissions.setPerCapitaEmissions(Double.parseDouble(emissionRequestDTO.getPerCapitaEmissions()));
        emissions.setEntryDate(LocalDate.parse(emissionRequestDTO.getEntryDate()));

        Emissions updatedEmission = emissionsRepository.save(emissions);
        return EmissionsMapper.toDTO(updatedEmission);
    }

    public void deleteEmission(UUID id) {
        emissionsRepository.deleteById(id);
    }
}
