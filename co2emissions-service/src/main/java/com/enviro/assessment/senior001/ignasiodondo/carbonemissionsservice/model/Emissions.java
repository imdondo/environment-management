package com.enviro.assessment.senior001.ignasiodondo.carbonemissionsservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Emissions {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID   emissionId;
    @NotNull
    private String emissionYear;
    //    @ManyToOne
    @JoinColumn(name = "id")
    private UUID countryId;
    @NotNull
    private Double totalEmissions;
    @NotNull
    private Double coalEmissions;
    @NotNull
    private Double oilEmissions;
    @NotNull
    private Double gasEmissions;
    @NotNull
    private Double cementEmissions;
    @NotNull
    private Double flaringEmissions;
    @NotNull
    private Double otherEmissions;
    @NotNull
    private Double perCapitaEmissions;
    @NotNull
    private LocalDate entryDate;

    public @NotNull LocalDate getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(@NotNull LocalDate entryDate) {
        this.entryDate = entryDate;
    }


    public UUID getEmissionId() {
        return emissionId;
    }

    public void setEmissionId(UUID emissionId) {
        this.emissionId = emissionId;
    }

    public @NotNull String getEmissionYear() {
        return emissionYear;
    }

    public void setEmissionYear(@NotNull String emissionYear) {
        this.emissionYear = emissionYear;
    }


    public @NotNull Double getTotalEmissions() {
        return totalEmissions;
    }

    public void setTotalEmissions(@NotNull Double totalEmissions) {
        this.totalEmissions = totalEmissions;
    }

    public @NotNull Double getCoalEmissions() {
        return coalEmissions;
    }

    public void setCoalEmissions(@NotNull Double coalEmissions) {
        this.coalEmissions = coalEmissions;
    }

    public @NotNull Double getGasEmissions() {
        return gasEmissions;
    }

    public void setGasEmissions(@NotNull Double gasEmissions) {
        this.gasEmissions = gasEmissions;
    }

    public @NotNull Double getCementEmissions() {
        return cementEmissions;
    }

    public void setCementEmissions(@NotNull Double cementEmissions) {
        this.cementEmissions = cementEmissions;
    }

    public @NotNull Double getFlaringEmissions() {
        return flaringEmissions;
    }

    public void setFlaringEmissions(@NotNull Double flaringEmissions) {
        this.flaringEmissions = flaringEmissions;
    }

    public @NotNull Double getOtherEmissions() {
        return otherEmissions;
    }

    public void setOtherEmissions(@NotNull Double otherEmissions) {
        this.otherEmissions = otherEmissions;
    }

    public @NotNull Double getPerCapitaEmissions() {
        return perCapitaEmissions;
    }

    public void setPerCapitaEmissions(@NotNull Double perCapitaEmissions) {
        this.perCapitaEmissions = perCapitaEmissions;
    }

    public UUID getCountryId() {
        return countryId;
    }

    public void setCountryId(UUID countryId) {
        this.countryId = countryId;
    }


    public @NotNull Double getOilEmissions() {
        return oilEmissions;
    }

    public void setOilEmissions(@NotNull Double oilEmissions) {
        this.oilEmissions = oilEmissions;
    }
    //    "Year","Total","Coal","Oil","Gas","Cement","Flaring","Other","Per Capita"

}
