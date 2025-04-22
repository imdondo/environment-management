package com.enviro.assessment.senior001.ignasiodondo.carbonemissionsservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Country {

    public Country(UUID Id, String name, String code, int UN_M49, LocalDate registeredDate) {
        this.Id = Id;
        this.name = name;
        this.code = code;
        this.UN_M49 = UN_M49;
        this.registeredDate= registeredDate;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "Id")
    private UUID Id;

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
    @Column(name="registeredDate")
    private LocalDate registeredDate;

    public LocalDate getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(LocalDate registeredDate) {
        this.registeredDate = registeredDate;
    }

    public Country() {

    }

    public UUID getId() {
        return Id;
    }

    public void setId(UUID Id) {
        this.Id = Id;
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
