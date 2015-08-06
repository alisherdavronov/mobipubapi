package org.mobipub.api.v1.dao;

import org.mobipub.api.v1.mappers.UserRoleMapper;
import org.mobipub.api.v1.models.UserRole;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

@RegisterMapper(UserRoleMapper.class)
public interface UserRoleDAO {

    @SqlQuery("select * from user_roles where id = :id")
    public UserRole getById(@Bind("id") int id);

    @SqlQuery("select * from user_roles where user_id = :user_id")
    public List<UserRole> getListByUserId(@Bind("user_id") int userId);

    @SqlQuery("select * from user_roles where user_id = :user_id and base_id = :base_id")
    public UserRole getByUserAndBaseId(@Bind("user_id") int userId, @Bind("base_id") int baseId);

    @SqlQuery("select role from user_roles where user_id = :user_id and base_id = :base_id")
    public String getRoleByUserAndBaseId(@Bind("user_id") int userId, @Bind("base_id") int baseId);

}
