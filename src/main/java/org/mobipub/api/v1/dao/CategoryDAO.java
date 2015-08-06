package org.mobipub.api.v1.dao;

import org.mobipub.api.v1.mappers.CategoryMapper;
import org.mobipub.api.v1.models.Category;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

@RegisterMapper(CategoryMapper.class)
public interface CategoryDAO {

    @SqlQuery("select * from categories where id = :id")
    public Category getById(@Bind("id") int id);

    @SqlQuery("select count(*) from categories where base_id = :base_id")
    public int countByBaseId(@Bind("base_id") int baseId);

    @SqlQuery("select * from categories where base_id = :base_id order by lft limit :limit offset :offset")
    public List<Category> getPagedList(@Bind("base_id") int baseId, @Bind("offset") int offset, @Bind("limit") int limit);
}
