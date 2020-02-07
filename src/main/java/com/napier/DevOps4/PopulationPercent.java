package com.napier.DevOps4;

public class PopulationPercent {
    public String continentName;
    public String regionName;
    public String countryName;
    public Long countryPopulation;
    public Long liveInCity;
    public Float liveInCityPercent;
    public Long noLiveInCity;
    public Float noLiveInCityPercent;

    public String getContinentName() {
        return continentName;
    }

    public void setContinentName(String continentName) {
        this.continentName = continentName;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Long getCountryPopulation() {
        return countryPopulation;
    }

    public void setCountryPopulation(Long countryPopulation) {
        this.countryPopulation = countryPopulation;
    }

    public Long getLiveInCity() {
        return liveInCity;
    }

    public void setLiveInCity(Long liveInCity) {
        this.liveInCity = liveInCity;
    }

    public Float getLiveInCityPercent() {
        return liveInCityPercent;
    }

    public void setLiveInCityPercent(Float liveInCityPercent) {
        this.liveInCityPercent = liveInCityPercent;
    }

    public Long getNoLiveInCity() {
        return noLiveInCity;
    }

    public void setNoLiveInCity(Long noLiveInCity) {
        this.noLiveInCity = noLiveInCity;
    }

    public Float getNoLiveInCityPercent() {
        return noLiveInCityPercent;
    }

    public void setNoLiveInCityPercent(Float noLiveInCityPercent) {
        this.noLiveInCityPercent = noLiveInCityPercent;
    }
}