package com.enviro.assessment.senior001.ignasiodondo.carbonemissionsservice.mapper;

import com.enviro.assessment.senior001.ignasiodondo.carbonemissionsservice.dto.CountryRequestDTO;
import com.enviro.assessment.senior001.ignasiodondo.carbonemissionsservice.dto.CountryResponseDTO;
import com.enviro.assessment.senior001.ignasiodondo.carbonemissionsservice.model.Country;

public class CountryMapper {
    public static CountryResponseDTO toDTO(Country country) {
        CountryResponseDTO countryDTO = new CountryResponseDTO();
//        countryDTO.setCountryId(country.getCountryId().toString());
        countryDTO.setName((country.getName()));
        countryDTO.setCode((country.getCode()));
        countryDTO.setUN_M49(String.valueOf((country.getUN_M49())));
        countryDTO.setRegisteredDate((country.getRegisteredDate().toString()));
        return countryDTO;
    }

    public static Country toModel(CountryRequestDTO countryRequestDTO) {
        Country country = new Country();
        country.setName(countryRequestDTO.getName());
        country.setCode((countryRequestDTO.getCode()));
        country.setUN_M49((countryRequestDTO.getUN_M49()));
        country.setRegisteredDate((countryRequestDTO.getRegisteredDate()));
        return country;
    }
}
