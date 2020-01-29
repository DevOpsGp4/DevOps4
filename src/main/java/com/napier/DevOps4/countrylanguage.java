package com.napier.DevOps4;

public class countrylanguage {
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
    public Enum IsOfficial;
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

    public Enum getIsOfficial() {
        return IsOfficial;
    }

    public void setIsOfficial(Enum isOfficial) {
        IsOfficial = isOfficial;
    }

    public Float getPercentage() {
        return Percentage;
    }

    public void setPercentage(Float percentage) {
        Percentage = percentage;
    }
}
