package com.elasticlandlord.model;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

;

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
//    @ManyToOne (mappedBy = "id")
//    private int propertyId;


}
