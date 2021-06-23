package com.elasticlandlord.model;

import org.hibernate.validator.constraints.Range;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
public class Property extends AbstractIdEntity{

    @NotBlank(message = "Property Name is Required")
    @Size(min = 3, max = 100, message = "Property name must be between 3 and 100 characters")
    private String propertyName;

    @Size(max = 400, message = "Property description must be less than 400 characters")
    private String propertyDescription;

    @Range(min = 1, max = 99, message = "Properties with more than 99 units are not supported")
    private int unitCount;

    private PropertyType propertyType;

    // Correct way to map?
//    @OneToMany (mappedBy = "id")
//    private List<Tenant> tenants = new ArrayList<>();

    // Haven't added tenants into constructor, not mandatory
    public Property(String propertyName, String propertyDescription, int unitCount, PropertyType propertyType) {
        this.propertyName = propertyName;
        this.propertyDescription = propertyDescription;
        this.unitCount = unitCount;
        this.propertyType = propertyType;
    }

    public Property () {};

    public String getPropertyName() { return propertyName; }
    public void setPropertyName(String propertyName) { this.propertyName = propertyName; }
    public String getPropertyDescription() { return propertyDescription; }
    public void setPropertyDescription(String propertyDescription) { this.propertyDescription = propertyDescription; }
    public int getUnitCount() { return unitCount; }
    public void setUnitCount(int unitCount) { this.unitCount = unitCount; }
    public PropertyType getPropertyType() { return propertyType; }
    public void setPropertyType(PropertyType propertyType) { this.propertyType = propertyType; }
//    public List<Tenant> getTenants() { return tenants; }
//    public void setTenants(List<Tenant> tenants) { this.tenants = tenants; }
}
