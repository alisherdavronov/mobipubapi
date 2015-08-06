package org.mobipub.api.v1.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.sql.Timestamp;

@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
abstract public class LangEntity {
    private final int entityId;
    private final int languageId;

    protected LangEntity(int entityId, int languageId) {
        this.entityId = entityId;
        this.languageId = languageId;
    }

    public int getEntityId() {
        return entityId;
    }

    public int getLanguageId() {
        return languageId;
    }
}
