package com.java.konwledge.basicinfo.util;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *  @dept 上海软件研发中心
 *  @description TODO
 *  @author HaoXin.Liu
 *  @date 2020/7/22 10:22
 **/
@XmlType(propOrder = {"name", "capital", "foundation", "continent", "population"})
@XmlRootElement(name = "Country")
public class Country {
    private int population;
    private String name;
    private String capital;
    private int importance;
    private String foundation;
    private String continent;

    public String getFoundation() {
        return foundation;
    }

    public void setFoundation(String foundation) {
        this.foundation = foundation;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    @XmlElement(name = "Country_Population")
    public void setPopulation(int population) {
        this.population = population;
    }


    @XmlElement(name = "Country_Name")
    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "Country_Capital")
    public void setCapital(String capital) {
        this.capital = capital;
    }

    @XmlAttribute(name = "importance", required = true)
    public void setImportance(int importance) {
        this.importance = importance;
    }

    public int getPopulation() {
        return population;
    }

    public String getName() {
        return name;
    }

    public String getCapital() {
        return capital;
    }

    public int getImportance() {
        return importance;
    }

    @Override
    public String toString() {
        return "Country{" +
                "population=" + population +
                ", name='" + name + '\'' +
                ", capital='" + capital + '\'' +
                ", importance=" + importance +
                ", foundation='" + foundation + '\'' +
                ", continent='" + continent + '\'' +
                '}';
    }
}