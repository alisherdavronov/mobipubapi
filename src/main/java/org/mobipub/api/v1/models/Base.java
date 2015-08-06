package org.mobipub.api.v1.models;


import java.sql.Timestamp;

public class Base extends Entity {
    private final int ownerId;
    private final int isApiAvailable;
    private final int pos;

    public Base(
            int id,
            int ownerId,
            int isApiAvailable,
            int pos,
            Timestamp createdAt,
            Timestamp updatedAt) {
        super(id, createdAt, updatedAt);
        this.ownerId = ownerId;
        this.isApiAvailable = isApiAvailable;
        this.pos = pos;
    }

    public int getOwnerId() {
        return ownerId;
    }
    public int getIsApiAvailable() {
        return isApiAvailable;
    }
    public int getPos() {
        return pos;
    }
}
