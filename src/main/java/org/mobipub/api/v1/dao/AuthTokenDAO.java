package org.mobipub.api.v1.dao;

import org.mobipub.api.v1.mappers.AuthTokenMapper;
import org.mobipub.api.v1.models.AuthToken;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

@RegisterMapper(AuthTokenMapper.class)
public interface AuthTokenDAO {

    @SqlQuery("select * from auth_tokens where id = :id")
    public AuthToken getById(@Bind("id") int id);

    @SqlQuery("select * from auth_tokens where token = :token")
    public AuthToken getByToken(@Bind("token") String token);

    @SqlUpdate("insert into auth_tokens (token, valid_until, user_id, created_at, updated_at) values (:token, :validUntil, :userId, :createdAt, :updatedAt)")
    public int create(@BindBean AuthToken authToken);

    @SqlUpdate("update auth_tokens set valid_until = :validUntil, updated_at = :updatedAt where token = :token")
    public int update(@BindBean AuthToken authToken);
}