package org.mobipub.api.v1.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

public class UserRole extends Entity {
    @Min(1)
    private final int userId;
    @Min(1)
    private final int baseId;
    @NotNull
    @Size(max=255)
    private final String role;

    public UserRole(
            int id,
            int userId,
            int baseId,
            String role,
            Timestamp createdAt,
            Timestamp updatedAt
    ) {
        super(id, createdAt, updatedAt);
        this.userId = userId;
        this.baseId = baseId;
        this.role = role;
    }

    public int getUserId() {
        return userId;
    }

    public int getBaseId() {
        return baseId;
    }

    public String getRole() {
        return role;
    }
}
