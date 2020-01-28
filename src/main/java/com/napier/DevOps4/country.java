package com.napier.DevOps4;

public class country {

    /**
     * Country Code
     */
    public String Code;

    public String getCode(String string) {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }
    /**
     * Country Name
     */
    public String Name;

    public String getName(String string) {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
    /**
     * Country Continent
     */
    public String Continent;

    public String getContinent(String string) {
        return Continent;
    }

    public void setContinent(String continent) {
        Continent = continent;
    }
    /**
     * Country Region
     */
    public String Region;

    public String getRegion(String string) {
        return Region;
    }

    public void setRegion(String region) {
        Region = region;
    }

    /**
     * Country SurfaceArea
     */
    public Float SurfaceArea;

    public Float getSurfaceArea() {
        return SurfaceArea;
    }

    public void setSurfaceArea(Float surfaceArea) {
        SurfaceArea = surfaceArea;
    }
    /**
     * Country IndepYear
     */
    public Integer IndepYear;

    public Integer getIndepYear() {
        return IndepYear;
    }

    public void setIndepYear(Integer indepYear) {
        IndepYear = indepYear;
    }
    /**
     * Country Population
     */
    public Integer Population;

    public Integer getPopulation(String string) {
        return Population;
    }

    public void setPopulation(Integer population) {
        Population = population;
    }

    /**
     * Country LifeExpectancy
     */
    public Float LifeExpectancy;

    public Float getLifeExpectancy() {
        return LifeExpectancy;
    }

    public void setLifeExpectancy(Float lifeExpectancy) {
        LifeExpectancy = lifeExpectancy;
    }
    /**
     * Country GNP
     */
    public Float GNP;

    public Float getGNP() {
        return GNP;
    }

    public void setGNP(Float GNP) {
        this.GNP = GNP;
    }
    /**
     * Country GNPOld
     */
    public Float GNPOld;

    public Float getGNPOld() {
        return GNPOld;
    }

    public void setGNPOld(Float GNPOld) {
        this.GNPOld = GNPOld;
    }
    /**
     * Country LocalName
     */
    public String LocalName;

    public String getLocalName() {
        return LocalName;
    }

    public void setLocalName(String localName) {
        LocalName = localName;
    }
    /**
     * Country GovernmentForm
     */
    public String GovernmentForm;

    public String getGovernmentForm() {
        return GovernmentForm;
    }

    public void setGovernmentForm(String governmentForm) {
        GovernmentForm = governmentForm;
    }
    /**
     * Country HeadOfState
     */
    public String HeadOfState;

    public String getHeadOfState() {
        return HeadOfState;
    }

    public void setHeadOfState(String headOfState) {
        HeadOfState = headOfState;
    }
    /**
     * Country Capital
     */
    public String Capital;

    public String getCapital(String string) {
        return Capital;
    }

    public void setCapital(String capital) {
        Capital = capital;
    }
    /**
     * Country Code2
     */
    public String Code2;

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
                ", Capital - " + Capital ;
    }
}
