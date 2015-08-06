package org.mobipub.api.v1.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

public class MobileUser extends Entity {

    private final Integer baseId;

    @NotNull
    @Size(min=3, max=255)
    private final String email;

    @NotNull
    @Size(max=255)
    private final String passwordHash;

    public MobileUser(int id, Integer baseId, String email, String passwordHash, Timestamp createdAt, Timestamp updatedAt) {
        super(id, createdAt, updatedAt);
        this.baseId = baseId;
        this.email = email;
        this.passwordHash = passwordHash;
    }

    public Integer getBaseId() {
        return baseId;
    }

    public String getEmail() {
        return email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }
}
