package org.mobipub.api.v1.models;

import javax.validation.constraints.Size;
import java.sql.Timestamp;

public class MobileUserAppStart extends Entity {
    private final Integer userId;
    private final int baseId;
    @Size(max=255)
    private final String deviceId;
    @Size(max=255)
    private final String userMarketId;

    public MobileUserAppStart(int id, Integer userId, int baseId, String deviceId, String userMarketId, Timestamp createdAt, Timestamp updatedAt) {
        super(id, createdAt, updatedAt);
        this.userId = userId;
        this.baseId = baseId;
        this.deviceId = deviceId;
        this.userMarketId = userMarketId;
    }

    public Integer getUserId() {
        return userId;
    }

    public int getBaseId() {
        return baseId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public String getUserMarketId() {
        return userMarketId;
    }
}
