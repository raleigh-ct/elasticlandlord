package com.elasticlandlord.model;

public enum LeaseType {

    M2M("Month-to-Month"),
    FIXED("Fixed-Length");

    private final String displayName;

    LeaseType(String displayName) { this.displayName = displayName; }

    public String getDisplayName() {
        return displayName;
    }
}