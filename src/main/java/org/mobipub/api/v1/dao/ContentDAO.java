package org.mobipub.api.v1.dao;


import org.mobipub.api.v1.mappers.ContentMapper;
import org.mobipub.api.v1.models.Content;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

@RegisterMapper(ContentMapper.class)
public interface ContentDAO {

    @SqlQuery("select * from contents where id = :id")
    public Content getById(@Bind("id") int id);

    @SqlQuery("select count(*) from contents where category_id = :category_id")
    public int countByCategoryId(@Bind("category_id") int categoryId);

    @SqlQuery("select * from contents where category_id = :category_id order by id limit :limit offset :offset")
    public List<Content> getPagedList(@Bind("category_id") int baseId, @Bind("offset") int offset, @Bind("limit") int limit);
}
