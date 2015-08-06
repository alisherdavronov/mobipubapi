package org.mobipub.api.v1.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class Content extends Entity {
    @Min(1)
    private final int categoryId;
    @NotNull
    private final String name;
    @NotNull
    private final String fullName;
    private final String description;
    private final boolean published;
    @NotNull
    @Size(max=255)
    private final String accessType;
    private final Boolean paid;
    private final BigDecimal cost;
    @Size(max=255)
    private final String currency;
    @JsonIgnore
    private final Timestamp exportedAt;

    public Content(
            int id,
            int categoryId,
            String name,
            String fullName,
            String description,
            boolean published,
            String accessType,
            Boolean paid,
            BigDecimal cost,
            String currency,
            Timestamp exportedAt,
            Timestamp createdAt,
            Timestamp updatedAt
    ) {
        super(id, createdAt, updatedAt);
        this.categoryId = categoryId;
        this.name = name;
        this.fullName = fullName;
        this.description = description;
        this.published = published;
        this.accessType = accessType;
        this.paid = paid;
        this.cost = cost;
        this.currency = currency;
        this.exportedAt = exportedAt;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public String getName() {
        return name;
    }

    public String getFullName() {
        return fullName;
    }

    public String getDescription() {
        return description;
    }

    public boolean isPublished() {
        return published;
    }

    public String getAccessType() {
        return accessType;
    }

    public Boolean isPaid() {
        return paid;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public String getCurrency() {
        return currency;
    }

    public Timestamp getExportedAt() {
        return exportedAt;
    }

    @JsonProperty("exportedAt")
    public String getExportedAtAsString() {
        if (exportedAt == null) return null;
        return exportedAt.toString();
    }

}
