package org.mobipub.api.v1.dao;

import org.mobipub.api.v1.mappers.ContentElementMapper;
import org.mobipub.api.v1.models.ContentElement;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

@RegisterMapper(ContentElementMapper.class)
public interface ContentElementDAO {

    @SqlQuery("select * from content_elements where content_id = :content_id order by order_number")
    public List<ContentElement> getListByContentId(@Bind("content_id") int contentId);

}
