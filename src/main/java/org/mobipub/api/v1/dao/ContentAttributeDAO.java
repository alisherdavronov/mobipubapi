package org.mobipub.api.v1.dao;

import org.mobipub.api.v1.mappers.ContentAttributeMapper;
import org.mobipub.api.v1.models.ContentAttribute;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

@RegisterMapper(ContentAttributeMapper.class)
public interface ContentAttributeDAO {

    @SqlQuery("select * from content_attributes where content_id = :content_id order by order_number")
    public List<ContentAttribute> getListByContentId(@Bind("content_id") int contentId);

}
