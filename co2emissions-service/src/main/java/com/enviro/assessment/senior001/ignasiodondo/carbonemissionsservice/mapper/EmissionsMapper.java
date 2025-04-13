package com.enviro.assessment.senior001.ignasiodondo.carbonemissionsservice.mapper;

import com.enviro.assessment.senior001.ignasiodondo.carbonemissionsservice.dto.EmissionRequestDTO;
import com.enviro.assessment.senior001.ignasiodondo.carbonemissionsservice.dto.EmissionResponseDTO;
import com.enviro.assessment.senior001.ignasiodondo.carbonemissionsservice.model.Emissions;

import java.time.LocalDate;

public class EmissionsMapper {
    public static EmissionResponseDTO toDTO(Emissions emissions) {
        EmissionResponseDTO emissionsDTO = new EmissionResponseDTO();
        emissionsDTO.setEmissionId(emissions.getEmissionId().toString());
        emissionsDTO.setEmissionYear((emissions.getEmissionYear()));
        emissionsDTO.setCountryId((emissions.getCountryId().toString()));
        emissionsDTO.setTotalEmissions((emissions.getTotalEmissions().toString()));
        emissionsDTO.setCoalEmissions(emissions.getCoalEmissions().toString());
        emissionsDTO.setOilEmissions(emissions.getOilEmissions().toString());
        emissionsDTO.setGasEmissions(emissions.getGasEmissions().toString());
        emissionsDTO.setCementEmissions(emissions.getCementEmissions().toString());
        emissionsDTO.setFlaringEmissions(emissions.getFlaringEmissions().toString());
        emissionsDTO.setTotalEmissions(emissions.getTotalEmissions().toString());
        emissionsDTO.setOtherEmissions(emissions.getOtherEmissions().toString());
        emissionsDTO.setPerCapitaEmissions(emissions.getPerCapitaEmissions().toString());
        return emissionsDTO;
    }

    public static Emissions toModel(EmissionRequestDTO emissionRequestDTO) {
        Emissions emissions = new Emissions();
        emissions.setEmissionYear(emissionRequestDTO.getEmissionYear());
        emissions.setCountryId((emissionRequestDTO.getCountryId()));
        emissions.setTotalEmissions(Double.valueOf(emissionRequestDTO.getTotalEmissions()));
        emissions.setCoalEmissions(Double.valueOf(emissionRequestDTO.getCoalEmissions()));
        emissions.setOilEmissions(Double.valueOf(emissionRequestDTO.getOilEmissions()));
        emissions.setGasEmissions(Double.valueOf(emissionRequestDTO.getGasEmissions()));
        emissions.setCementEmissions(Double.valueOf(emissionRequestDTO.getCementEmissions()));
        emissions.setFlaringEmissions(Double.valueOf(emissionRequestDTO.getFlaringEmissions()));
        emissions.setOtherEmissions(Double.valueOf(emissionRequestDTO.getOtherEmissions()));
        emissions.setPerCapitaEmissions(Double.valueOf(emissionRequestDTO.getPerCapitaEmissions()));
        emissions.setEntryDate(LocalDate.parse(emissionRequestDTO.getEntryDate()));
        return emissions;
    }
}
