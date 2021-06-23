package com.elasticlandlord.model;

public enum PropertyType {

    SINGLE("Single Family"),
    SMALLMULTI("Small Multifamily"),
    COMPLEX("Apartment Complex"),
    VACATION("Vacation"),
    OTHER("Other");

    private final String displayName;

    EventType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
