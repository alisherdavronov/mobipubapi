package org.mobipub.api.v1.forms;

import javax.validation.constraints.Size;

public class MobileUserLocationForm {
    private final Integer mobileUserId;
    private final int baseId;
    @Size(max=255)
    private final String deviceId;
    @Size(max=255)
    private final String userMarketId;
    private final double lat;
    private final double lon;

    public MobileUserLocationForm(Integer mobileUserId, int baseId, String deviceId, String userMarketId, double lat, double lon) {
        this.mobileUserId = mobileUserId;
        this.baseId = baseId;
        this.deviceId = deviceId;
        this.userMarketId = userMarketId;
        this.lat = lat;
        this.lon = lon;
    }

    public Integer getMobileUserId() {
        return mobileUserId;
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
