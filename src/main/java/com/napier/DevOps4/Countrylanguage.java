package com.napier.DevOps4;

import sun.font.TrueTypeFont;

import static java.lang.Boolean.TYPE;
import static java.lang.Boolean.valueOf;
import static java.util.jar.Pack200.Packer.TRUE;

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
