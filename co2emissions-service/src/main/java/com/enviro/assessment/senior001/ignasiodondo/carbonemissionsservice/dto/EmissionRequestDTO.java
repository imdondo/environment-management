package com.enviro.assessment.senior001.ignasiodondo.carbonemissionsservice.dto;

import com.enviro.assessment.senior001.ignasiodondo.carbonemissionsservice.validators.CreateEmissionValidationGroup;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public class EmissionRequestDTO {
    @NotBlank(message = "EmissionYear is required")
    @Size(max = 9999, message = "Year cannot exceed 4 digits")
    private String emissionYear;

    @NotBlank(message = "country is required")
    private String countryId;

    @NotBlank(message = "totalEmissions is required")
    private String totalEmissions;

    @NotBlank(message = "Coal Emissions is required")
    private String coalEmissions;

    @NotBlank(message = "Oil Emissions is required")
    private String oilEmissions;

    @NotBlank(message = "Gas emissions is required")
    private String gasEmissions;

    @NotBlank(message = "Cement Emissions is required")
    private String cementEmissions;

    @NotBlank(message = "Flaring emissions is required")
    private String flaringEmissions;

    @NotBlank(message = "Other Emissions is required")
    private String otherEmissions;
    @NotBlank(message = "Per Capita Emissions is required")
    private String perCapitaEmissions;

    @NotBlank(groups = CreateEmissionValidationGroup.class, message =
            "Entry date is required")
    private String entryDate;

    public void setCountryId(@NotBlank(message = "country is required") String countryId) {
        this.countryId = countryId;
    }

    public @NotBlank(message = "Oil Emissions is required") String getOilEmissions() {
        return oilEmissions;
    }

    public void setOilEmissions(@NotBlank(message = "Oil Emissions is required") String oilEmissions) {
        this.oilEmissions = oilEmissions;
    }

    public  String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate( String entryDate) {
        this.entryDate = entryDate;
    }

    public @NotBlank(message = "Per Capita Emissions is required") String getPerCapitaEmissions() {
        return perCapitaEmissions;
    }

    public void setPerCapitaEmissions(@NotBlank(message = "Per Capita Emissions is required") String perCapitaEmissions) {
        this.perCapitaEmissions = perCapitaEmissions;
    }

    public @NotBlank(message = "Other Emissions is required") String getOtherEmissions() {
        return otherEmissions;
    }

    public void setOtherEmissions(@NotBlank(message = "Other Emissions is required") String otherEmissions) {
        this.otherEmissions = otherEmissions;
    }

    public @NotBlank(message = "Flaring emissions is required") String getFlaringEmissions() {
        return flaringEmissions;
    }

    public void setFlaringEmissions(@NotBlank(message = "Flaring emissions is required") String flaringEmissions) {
        this.flaringEmissions = flaringEmissions;
    }

    public @NotBlank(message = "Cement Emissions is required") String getCementEmissions() {
        return cementEmissions;
    }

    public void setCementEmissions(@NotBlank(message = "Cement Emissions is required") String cementEmissions) {
        this.cementEmissions = cementEmissions;
    }

    public @NotBlank(message = "Gas emissions is required") String getGasEmissions() {
        return gasEmissions;
    }

    public void setGasEmissions(@NotBlank(message = "Gas emissions is required") String gasEmissions) {
        this.gasEmissions = gasEmissions;
    }

    public @NotBlank(message = "Coal Emissions is required") String getCoalEmissions() {
        return coalEmissions;
    }

    public void setCoalEmissions(@NotBlank(message = "Coal Emissions is required") String coalEmissions) {
        this.coalEmissions = coalEmissions;
    }

    public @NotBlank(message = "totalEmissions is required") String getTotalEmissions() {
        return totalEmissions;
    }

    public void setTotalEmissions(@NotBlank(message = "totalEmissions is required") String totalEmissions) {
        this.totalEmissions = totalEmissions;
    }

    public UUID getCountryId() {
        return UUID.fromString(countryId);
    }


    public @NotBlank(message = "EmissionYear is required") @Size(max = 9999, message = "Year cannot exceed 4 digits") String getEmissionYear() {
        return emissionYear;
    }

    public void setEmissionYear(@NotBlank(message = "EmissionYear is required") @Size(max = 9999, message = "Year cannot exceed 4 digits") String emissionYear) {
        this.emissionYear = emissionYear;
    }



}
