package com.napier.DevOps4;

public class city {
    @Override
    public String toString() {
        return "city{" +
                "ID='" + ID + '\'' +
                ", Name='" + Name + '\'' +
                ", CountryCode='" + CountryCode + '\'' +
                ", District='" + District + '\'' +
                ", Population=" + Population +
                '}';
    }

    /**
     * City ID
     */
    private String ID;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    /**
     * City Name
     */
    private String Name;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
    /**
     * City CountryCode
     */
    private String CountryCode;

    public String getCountryCode() {
        return CountryCode;
    }

    public void setCountryCode(String countryCode) {
        CountryCode = countryCode;
    }
    /**
     * City District
     */
    private String District;

    public String getDistrict() {
        return District;
    }

    public void setDistrict(String district) {
        District = district;
    }
    /**
     * City Population
     */
    private Integer Population;

    public Integer getPopulation() {
        return Population;
    }

    public void setPopulation(Integer population) {
        Population = population;
    }
}
