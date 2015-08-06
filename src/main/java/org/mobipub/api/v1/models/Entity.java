package org.mobipub.api.v1.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.yammer.dropwizard.json.JsonSnakeCase;

import java.sql.Timestamp;

@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
abstract public class Entity {
    private final int id;
    @JsonIgnore
    private final Timestamp createdAt;
    @JsonIgnore
    private final Timestamp updatedAt;

    protected Entity(int id, Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return id;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    @JsonProperty("createdAt")
    public String getCreatedAtAsString() {
        if (createdAt == null) return null;
        return createdAt.toString();
    }

    @JsonProperty("updatedAt")
    public String getUpdatedAtAsString() {
        if (updatedAt == null) return null;
        return updatedAt.toString();
    }

}
