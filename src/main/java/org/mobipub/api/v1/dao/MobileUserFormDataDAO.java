package org.mobipub.api.v1.dao;

import org.mobipub.api.v1.models.MobileUserFormData;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

public interface MobileUserFormDataDAO {
    @SqlUpdate("insert into m_users_form_data (user_id, base_id, form_name, data_guid, data_key, data_value, created_at, updated_at) " +
                                      "values (:userId, :baseId, :formName, :dataGuid, :dataKey, :dataValue, :createdAt, :updatedAt)")
    public int create(@BindBean MobileUserFormData mobileUserFormData);
}
