package org.mobipub.api.v1.dao;

import org.mobipub.api.v1.mappers.BaseMapper;
import org.mobipub.api.v1.models.Base;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

@RegisterMapper(BaseMapper.class)
public interface BaseDAO {

    @SqlQuery("select * from base where id = :id")
    public Base getById(@Bind("id") int id);

}
