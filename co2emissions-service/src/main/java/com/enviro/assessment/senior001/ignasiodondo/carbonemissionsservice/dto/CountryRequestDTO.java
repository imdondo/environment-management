package com.enviro.assessment.senior001.ignasiodondo.carbonemissionsservice.dto;

import com.enviro.assessment.senior001.ignasiodondo.carbonemissionsservice.validators.CreateEmissionValidationGroup;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class CountryRequestDTO {

    @NotNull
    @Column
    private String name;
    @NotNull
    @Column
    private String code;
    @Size(min=1, max=1000)
    @Column
    private int UN_M49;
    @NotNull
    @Column
    private LocalDate registeredDate;

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

    public @NotNull LocalDate getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(@NotNull LocalDate registeredDate) {
        this.registeredDate = registeredDate;
    }
}
