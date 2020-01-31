package com.napier.DevOps4;

public class Countrylanguage {


    public String getCountryCode() {
        return CountryCode;
    }

    public void setCountryCode(String countryCode) {
        CountryCode = countryCode;
    }

    public String getIsOfficial() {
        if (IsOfficial.equals("T")){
            IsOfficial = "Official";
        }else {
            IsOfficial = "Not Official";
        }
        return IsOfficial;
    }

    public void setIsOfficial(String isOfficial) {
        IsOfficial = isOfficial;
    }

    public Float getPercentage() {
        return Percentage;
    }

    public void setPercentage(Float percentage) {
        Percentage = percentage;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return "countrylanguage{" +
                "Name='" + Name + '\'' +
                ", CountryCode='" + CountryCode + '\'' +
                ", Population='" + Population + '\'' +
                ", IsOfficial='" + IsOfficial + '\'' +
                ", Percentage=" + Percentage +
                '}';
    }

    /**
     * Country Name
     */
    public String Name;

    /**
     * CountryLanguage CountryCode
     */
    public String CountryCode;

    public String getPopulation() {
        return Population;
    }

    public void setPopulation(String population) {
        Population = population;
    }
    /**
     * CountryLanguage Language
     */
    public String Language;
    /**
     * Country Population
     */
    public String Population;

    /**
     * CountryLanguage IsOfficial
     */
    public String IsOfficial;

    /**
     * CountryLanguage Percentage
     */
    public Float Percentage;
}
