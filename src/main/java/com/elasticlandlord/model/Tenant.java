package com.elasticlandlord.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Tenant extends AbstractIdEntity{

    @NotBlank
    @Size(min = 3, max = 75, message = "Tenant name must be between 3 and 75 characters")
    private String tenantName;

    @Size(min = 3, max = 75, message = "Tenant name must be between 3 and 75 characters")
    private String cosignerName;

    @NotBlank
    private LeaseType leaseType;

    @NotBlank
    private int leaseLengthMonths;

    // Is this the right data type?
    @NotBlank
    private Date leaseSignedDate;

    // Is this the right data type?
    @NotBlank
    private Date leaseEndDate;

    // Many Tenants can be tied to the same propertyId?
    @ManyToOne
    private Property prop;

    public Tenant(String tenantName, String cosignerName, LeaseType leaseType, int leaseLengthMonths, Date leaseSignedDate, Date leaseEndDate, Property property) {
        this.tenantName = tenantName;
        this.cosignerName = cosignerName;
        this.leaseType = leaseType;
        this.leaseLengthMonths = leaseLengthMonths;
        this.leaseSignedDate = leaseSignedDate;
        this.leaseEndDate = leaseEndDate;
        this.prop = property;
    }

    public Tenant(){};

    public String getTenantName() { return tenantName; }
    public void setTenantName(String tenantName) { this.tenantName = tenantName; }
    public String getCosignerName() { return cosignerName; }
    public void setCosignerName(String cosignerName) { this.cosignerName = cosignerName; }
    public LeaseType getLeaseType() { return leaseType; }
    public void setLeaseType(LeaseType leaseType) { this.leaseType = leaseType; }
    public int getLeaseLengthMonths() { return leaseLengthMonths; }
    public void setLeaseLengthMonths(int leaseLengthMonths) { this.leaseLengthMonths = leaseLengthMonths; }
    public Date getLeaseSignedDate() { return leaseSignedDate; }
    public void setLeaseSignedDate(Date leaseSignedDate) { this.leaseSignedDate = leaseSignedDate; }
    public Date getLeaseEndDate() { return leaseEndDate; }
    public void setLeaseEndDate(Date leaseActionDate) { this.leaseEndDate = leaseActionDate; }
    public Property getPropertyId() { return prop; }
    public void setPropertyId(Property propertyId) { this.prop = propertyId; }

    @Override
    public String toString() {
        return tenantName;
    }
}
