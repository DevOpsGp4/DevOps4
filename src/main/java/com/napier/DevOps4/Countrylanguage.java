package com.napier.DevOps4;

public class Countrylanguage {
    /**
     * CountryLanguage CountryCode
     */
    public String CountryCode;
    /**
     * CountryLanguage Language
     */
    public String Language;
    /**
     * CountryLanguage IsOfficial
     */
    public String IsOfficial;
    /**
     * CountryLanguage Percentage
     */
    public Float Percentage;

    public String getCountryCode() {
        return CountryCode;
    }

    public void setCountryCode(String countryCode) {
        CountryCode = countryCode;
    }

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String language) {
        Language = language;
    }

    public String getIsOfficial() {
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
}
