package com.elasticlandlord.model;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
public class Tenant extends AbstractIdEntity{

    @NotBlank
    @Size(min = 3, max = 75, message = "Tenant name must be between 3 and 75 characters")
    private String tenantName;

    @Size(min = 3, max = 75, message = "Tenant name must be between 3 and 75 characters")
    private String tenantTwoName;

    // Should I make another enum for month-to-month, months, year?
    @NotBlank
    private int leaseLengthMonths;

    // Is this the right data type?
    @NotBlank
    private LocalDate leaseSignedDate;

    // Is this the right data type?
    @NotBlank
    private LocalDate leaseActionDate;

    // Many Tenants can be tied to the same propertyId?
    private int propertyId;

    public Tenant(String tenantName, String tenantTwoName, int leaseLengthMonths, LocalDate leaseSignedDate, LocalDate leaseActionDate, int propertyId) {
        this.tenantName = tenantName;
        this.tenantTwoName = tenantTwoName;
        this.leaseLengthMonths = leaseLengthMonths;
        this.leaseSignedDate = leaseSignedDate;
        this.leaseActionDate = leaseActionDate;
        this.propertyId = propertyId;
    }

    public Tenant(){};

    public String getTenantName() { return tenantName; }
    public void setTenantName(String tenantName) { this.tenantName = tenantName; }
    public String getTenantTwoName() { return tenantTwoName; }
    public void setTenantTwoName(String tenantTwoName) { this.tenantTwoName = tenantTwoName; }
    public int getLeaseLengthMonths() { return leaseLengthMonths; }
    public void setLeaseLengthMonths(int leaseLengthMonths) { this.leaseLengthMonths = leaseLengthMonths; }
    public LocalDate getLeaseSignedDate() { return leaseSignedDate; }
    public void setLeaseSignedDate(LocalDate leaseSignedDate) { this.leaseSignedDate = leaseSignedDate; }
    public LocalDate getLeaseActionDate() { return leaseActionDate; }
    public void setLeaseActionDate(LocalDate leaseActionDate) { this.leaseActionDate = leaseActionDate; }
    public int getPropertyId() { return propertyId; }
    public void setPropertyId(int propertyId) { this.propertyId = propertyId; }

    @Override
    public String toString() {
        return tenantName;
    }
}
