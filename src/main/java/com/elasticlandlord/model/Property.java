package com.elasticlandlord.model;

import javax.persistence.Entity;
import javax.validation.NotBlank;


@Entity
public class Property extends AbstractIdEntity{

    @NotBlank(message = "Property Name is Required")
    @Size(min = 3, max = 100, message = "Property name must be between 3 and 100 characters")
    private String propertyName;

    @Size(max = 400, message = "Property description must be less than 400 characters")
    private String propertyDescription;
}
