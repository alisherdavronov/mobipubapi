package org.mobipub.api.v1.dao;

import org.mobipub.api.v1.models.MobileUserLocation;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

public interface MobileUserLocationDAO {
    @SqlUpdate("insert into m_users_locations (user_id, base_id, device_id, user_market_id, lat, lon, created_at, updated_at) " +
                                      "values (:userId, :baseId, :deviceId, :lat, :lon, :userMarketId, :createdAt, :updatedAt)")
    public int create(@BindBean MobileUserLocation mobileUserLocation);
}
