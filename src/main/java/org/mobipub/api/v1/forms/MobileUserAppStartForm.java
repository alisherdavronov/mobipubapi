package org.mobipub.api.v1.forms;

import javax.validation.constraints.Size;

public class MobileUserAppStartForm {
    private final Integer mobileUserId;
    private final int baseId;
    @Size(max=255)
    private final String deviceId;
    @Size(max=255)
    private final String userMarketId;

    public MobileUserAppStartForm(Integer mobileUserId, int baseId, String deviceId, String userMarketId) {
        this.mobileUserId = mobileUserId;
        this.baseId = baseId;
        this.deviceId = deviceId;
        this.userMarketId = userMarketId;
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
}
