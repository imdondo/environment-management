package com.enviro.assessment.senior001.ignasiodondo.carbonemissionsservice.repository;

import com.enviro.assessment.senior001.ignasiodondo.carbonemissionsservice.model.Emissions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EmissionsRepository extends JpaRepository<Emissions, UUID> {
    boolean existsByEmissionYearAndCountryIdNot(String emissionYear, UUID countryId);
}
