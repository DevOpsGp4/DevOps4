package com.napier.DevOps4;

public class countrylanguage {
    @Override
    public String toString() {
        return "countrylanguage{" +
                "CountryCode='" + CountryCode + '\'' +
                ", Language='" + Language + '\'' +
                ", IsOfficial=" + IsOfficial +
                ", Percentage=" + Percentage +
                '}';
    }

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

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    /**
     * CountryLanguage CountryCode
     */
    public String Name;

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
}
