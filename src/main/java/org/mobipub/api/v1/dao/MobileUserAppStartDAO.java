package org.mobipub.api.v1.dao;

import org.mobipub.api.v1.models.MobileUserAppStart;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

public interface MobileUserAppStartDAO {
    @SqlUpdate("insert into m_users_app_start (user_id, base_id, device_id, user_market_id, created_at, updated_at) " +
                                      "values (:userId, :baseId, :deviceId, :userMarketId, :createdAt, :updatedAt)")
    public int create(@BindBean MobileUserAppStart mobileUserAppStart);
}
