package org.mobipub.api.v1.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

public class AuthToken extends Entity {
    @NotNull
    @Size(max=255)
    private final String token;
    private final Timestamp validUntil;
    @Min(1)
    private final int userId;

    public AuthToken(
            int id,
            String token,
            Timestamp validUntil,
            int userId,
            Timestamp createdAt,
            Timestamp updatedAt
    ) {
        super(id, createdAt, updatedAt);
        this.token = token;
        this.validUntil = validUntil;
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public String getToken() {
        return token;
    }

    public Timestamp getValidUntil() {
        return validUntil;
    }
}
