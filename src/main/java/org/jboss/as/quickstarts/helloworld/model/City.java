package org.jboss.as.quickstarts.helloworld.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import javax.validation.constraints.NotNull;


import java.io.Serializable;

@Entity
@Table(name="city", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class City implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    private Integer id;

    @NotNull
    @Column(name = "Name")
    private String name;
    @Column(name = "District")
    private String district;
    @Column(name = "Population")
    private Integer population;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }
}
