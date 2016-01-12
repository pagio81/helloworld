package org.jboss.as.quickstarts.helloworld.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class Country implements Serializable{

    private static final long serialVersionUID = 1L;

    private String code;
    private String name;
    private String continent;
    private String region;
    private String surfaceArea;
    private String indepYear;
    private String population;
    private String lifeExpectancy;
    private String GNP;
    private String GNPOld;
    private String localName;
    private String governmentForm;
    private String headOfState;
    private String capital;
    private String code2;

}
