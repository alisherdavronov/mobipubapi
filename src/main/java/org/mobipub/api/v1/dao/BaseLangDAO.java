package org.mobipub.api.v1.dao;

import org.mobipub.api.v1.mappers.BaseLangMapper;
import org.mobipub.api.v1.models.BaseLang;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

@RegisterMapper(BaseLangMapper.class)
public interface BaseLangDAO {

    @SqlQuery("select * from base_lang where entity_id = :base_id")
    public List<BaseLang> getListByBaseId(@Bind("base_id") int baseId);

}
