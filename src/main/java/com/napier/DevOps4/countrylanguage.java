package com.napier.DevOps4;

public class countrylanguage {
    public String getCountryCode() {
        return CountryCode;
    }

    public void setCountryCode(String countryCode) {
        CountryCode = countryCode;
    }

    /**
     * CountryLanguage CountryCode
     */
    private String CountryCode;

    /**
     * CountryLanguage Language
     */
    public String Language;

    /**
     * CountryLanguage IsOfficial
     */
    public Enum IsOfficial;

    /**
     * CountryLanguage Percentage
     */
    public Float Percentage;
}
