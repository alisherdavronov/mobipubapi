package org.mobipub.api.v1.models;

import javax.validation.constraints.Size;
import java.sql.Timestamp;

public class MobileUserLocation extends Entity {
    private final Integer userId;
    private final int baseId;
    @Size(max=255)
    private final String deviceId;
    @Size(max=255)
    private final String userMarketId;
    private final double lat;
    private final double lon;

    public MobileUserLocation(
            int id,
            Integer userId,
            int baseId,
            String deviceId,
            String userMarketId,
            double lat,
            double lon,
            Timestamp createdAt,
            Timestamp updatedAt
    ) {
        super(id, createdAt, updatedAt);
        this.userId = userId;
        this.baseId = baseId;
        this.deviceId = deviceId;
        this.userMarketId = userMarketId;
        this.lat = lat;
        this.lon = lon;
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

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }
}
