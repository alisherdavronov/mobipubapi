package org.mobipub.api.v1.dao;

import org.mobipub.api.v1.mappers.MobileUserMapper;
import org.mobipub.api.v1.models.MobileUser;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

@RegisterMapper(MobileUserMapper.class)
public interface MobileUserDAO {

    @SqlQuery("select * from m_users where email = :email and base_id = :baseId")
    public MobileUser getByEmailAndBaseId(@Bind("email") String email, @Bind("baseId") int baseId);

    @SqlUpdate("insert into m_users (base_id, email, password_hash, created_at, updated_at) " +
                            "values (:baseId, :email, :passwordHash, :createdAt, :updatedAt)")
    public int create(@BindBean MobileUser mobileUser);
}
