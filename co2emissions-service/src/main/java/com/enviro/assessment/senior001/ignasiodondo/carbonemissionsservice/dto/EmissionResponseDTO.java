package com.enviro.assessment.senior001.ignasiodondo.carbonemissionsservice.dto;

public class EmissionResponseDTO {
    private String emissionId;
    private String emissionYear;
    private String country;
    private String totalEmissions;
    private String coalEmissions;
    private String oilEmissions;
    private String gasEmissions;
    private String cementEmissions;
    private String flaringEmissions;
    private String otherEmissions;
    private String perCapitaEmissions;

    public String getEmissionId() {
        return emissionId;
    }

    public void setEmissionId(String emissionId) {
        this.emissionId = emissionId;
    }

    public String getEmissionYear() {
        return emissionYear;
    }

    public void setEmissionYear(String emissionYear) {
        this.emissionYear = emissionYear;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTotalEmissions() {
        return totalEmissions;
    }

    public void setTotalEmissions(String totalEmissions) {
        this.totalEmissions = totalEmissions;
    }

    public String getCoalEmissions() {
        return coalEmissions;
    }

    public void setCoalEmissions(String coalEmissions) {
        this.coalEmissions = coalEmissions;
    }

    public String getGasEmissions() {
        return gasEmissions;
    }

    public void setGasEmissions(String gasEmissions) {
        this.gasEmissions = gasEmissions;
    }

    public String getCementEmissions() {
        return cementEmissions;
    }

    public void setCementEmissions(String cementEmissions) {
        this.cementEmissions = cementEmissions;
    }

    public String getFlaringEmissions() {
        return flaringEmissions;
    }

    public void setFlaringEmissions(String flaringEmissions) {
        this.flaringEmissions = flaringEmissions;
    }

    public String getOtherEmissions() {
        return otherEmissions;
    }

    public void setOtherEmissions(String otherEmissions) {
        this.otherEmissions = otherEmissions;
    }

    public String getPerCapitaEmissions() {
        return perCapitaEmissions;
    }

    public void setPerCapitaEmissions(String perCapitaEmissions) {
        this.perCapitaEmissions = perCapitaEmissions;
    }

    public String getOilEmissions() {
        return oilEmissions;
    }

    public void setOilEmissions(String oilEmissions) {
        this.oilEmissions = oilEmissions;
    }

}
