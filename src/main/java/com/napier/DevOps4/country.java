package com.napier.DevOps4;

public class country {

    /**
     * Country Code
     */
    public String Code;
    /**
     * Country Name
     */
    public String Name;
    /**
     * Country Continent
     */
    public String Continent;
    /**
     * Country Region
     */
    public String Region;
    /**
     * Country SurfaceArea
     */
    public Float SurfaceArea;
    /**
     * Country IndepYear
     */
    public Integer IndepYear;
    /**
     * Country Population
     */
    public Integer Population;
    /**
     * Country LifeExpectancy
     */
    public Float LifeExpectancy;
    /**
     * Country GNP
     */
    public Float GNP;
    /**
     * Country GNPOld
     */
    public Float GNPOld;
    /**
     * Country LocalName
     */
    public String LocalName;
    /**
     * Country GovernmentForm
     */
    public String GovernmentForm;
    /**
     * Country HeadOfState
     */
    public String HeadOfState;
    /**
     * Country Capital
     */
    public String Capital;
    /**
     * Country Code2
     */
    public String Code2;

    public String getCode(String string) {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getName(String string) {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getContinent(String string) {
        return Continent;
    }

    public void setContinent(String continent) {
        Continent = continent;
    }

    public String getRegion(String string) {
        return Region;
    }

    public void setRegion(String region) {
        Region = region;
    }

    public Float getSurfaceArea() {
        return SurfaceArea;
    }

    public void setSurfaceArea(Float surfaceArea) {
        SurfaceArea = surfaceArea;
    }

    public Integer getIndepYear() {
        return IndepYear;
    }

    public void setIndepYear(Integer indepYear) {
        IndepYear = indepYear;
    }

    public Integer getPopulation(String string) {
        return Population;
    }

    public void setPopulation(Integer population) {
        Population = population;
    }

    public Float getLifeExpectancy() {
        return LifeExpectancy;
    }

    public void setLifeExpectancy(Float lifeExpectancy) {
        LifeExpectancy = lifeExpectancy;
    }

    public Float getGNP() {
        return GNP;
    }

    public void setGNP(Float GNP) {
        this.GNP = GNP;
    }

    public Float getGNPOld() {
        return GNPOld;
    }

    public void setGNPOld(Float GNPOld) {
        this.GNPOld = GNPOld;
    }

    public String getLocalName() {
        return LocalName;
    }

    public void setLocalName(String localName) {
        LocalName = localName;
    }

    public String getGovernmentForm() {
        return GovernmentForm;
    }

    public void setGovernmentForm(String governmentForm) {
        GovernmentForm = governmentForm;
    }

    public String getHeadOfState() {
        return HeadOfState;
    }

    public void setHeadOfState(String headOfState) {
        HeadOfState = headOfState;
    }

    public String getCapital(String string) {
        return Capital;
    }

    public void setCapital(String capital) {
        Capital = capital;
    }

    public String getCode2() {
        return Code2;
    }

    public void setCode2(String code2) {
        Code2 = code2;
    }

    @Override
    public String toString() {
        return "Code - '" + Code + '\'' +
                ", Name - '" + Name + '\'' +
                ", Continent -'" + Continent + '\'' +
                ", Region - '" + Region + '\'' +
                ", Population - " + Population +
                ", Capital - " + Capital;
    }
}
