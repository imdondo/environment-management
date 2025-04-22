package com.enviro.assessment.senior001.ignasiodondo.carbonemissionsservice.dto;

public class CountryResponseDTO {
    private String name;
    private String code;
    private String UN_M49;
    private String registeredDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(String registeredDate) {
        this.registeredDate = registeredDate;
    }

    public String getUN_M49() {
        return UN_M49;
    }

    public void setUN_M49(String UN_M49) {
        this.UN_M49 = UN_M49;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
