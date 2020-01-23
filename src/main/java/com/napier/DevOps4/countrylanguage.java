package com.napier.DevOps4;

public class countrylanguage {
    /**
     * CountryLanguage CountryCode
     */
    private String CountryCode;

    public String getCountryCode() {
        return CountryCode;
    }

    public void setCountryCode(String countryCode) {
        CountryCode = countryCode;
    }
    /**
     * CountryLanguage Language
     */
    public String Language;

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String language) {
        Language = language;
    }
    /**
     * CountryLanguage IsOfficial
     */
    private Enum IsOfficial;

    public Enum getIsOfficial() {
        return IsOfficial;
    }

    public void setIsOfficial(Enum isOfficial) {
        IsOfficial = isOfficial;
    }
    /**
     * CountryLanguage Percentage
     */
    private Float Percentage;

    public Float getPercentage() {
        return Percentage;
    }

    public void setPercentage(Float percentage) {
        Percentage = percentage;
    }
}
