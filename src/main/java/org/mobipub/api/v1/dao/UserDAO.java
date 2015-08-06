package org.mobipub.api.v1.dao;

import org.mobipub.api.v1.mappers.UserMapper;
import org.mobipub.api.v1.models.User;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

@RegisterMapper(UserMapper.class)
public interface UserDAO {

    @SqlQuery("select * from users where id = :id")
    public User getById(@Bind("id") int id);

    @SqlQuery("select * from users where email = :email")
    public User getByEmail(@Bind("email") String email);

}
