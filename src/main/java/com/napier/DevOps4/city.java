package com.napier.DevOps4;

public class city {
    /**
     * City ID
     */
    public String ID;
    /**
     * City Name
     */
    public String Name;
    /**
     * City CountryCode
     */
    public String CountryCode;
    /**
     * City District
     */
    public String District;
    /**
     * City Population
     */
    public Integer Population;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCountryCode() {
        return CountryCode;
    }

    public void setCountryCode(String countryCode) {
        CountryCode = countryCode;
    }

    public String getDistrict() {
        return District;
    }

    public void setDistrict(String district) {
        District = district;
    }

    public Integer getPopulation() {
        return Population;
    }

    public void setPopulation(Integer population) {
        Population = population;
    }
}
