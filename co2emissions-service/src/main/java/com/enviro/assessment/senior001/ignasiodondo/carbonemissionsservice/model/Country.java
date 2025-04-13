package com.enviro.assessment.senior001.ignasiodondo.carbonemissionsservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

@Entity
public class Country {

    public Country(UUID countryId, String name, String code, int UN_M49) {
        this.countryId = countryId;
        this.name = name;
        this.code = code;
        this.UN_M49 = UN_M49;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private UUID countryId;

    @NotNull
    private String name;
    @NotNull
    private String code;
    @Size(min=1, max=1000)
    private int UN_M49;

    public Country() {

    }

    public UUID getCountryId() {
        return countryId;
    }

    public void setId(UUID countryId) {
        this.countryId = countryId;
    }

    public @NotNull String getName() {
        return name;
    }

    public void setName(@NotNull String name) {
        this.name = name;
    }

    public @NotNull String getCode() {
        return code;
    }

    public void setCode(@NotNull String code) {
        this.code = code;
    }

    @Size(min = 1, max = 1000)
    public int getUN_M49() {
        return UN_M49;
    }

    public void setUN_M49(@Size(min = 1, max = 1000) int UN_M49) {
        this.UN_M49 = UN_M49;
    }


}
