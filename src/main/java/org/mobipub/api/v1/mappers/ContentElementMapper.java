package org.mobipub.api.v1.mappers;

import org.mobipub.api.v1.models.ContentElement;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ContentElementMapper implements ResultSetMapper<ContentElement> {

    @Override
    public ContentElement map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        ContentElement contentElement = new ContentElement(
                resultSet.getInt("id"),
                resultSet.getInt("content_id"),
                resultSet.getInt("order_number"),
                resultSet.getString("lang"),
                resultSet.getString("name"),
                resultSet.getString("full_name"),
                resultSet.getString("content_text"),
                resultSet.getString("content_type"),
                resultSet.getString("content_path"),
                resultSet.getString("icon_path"),
                resultSet.getString("tags"),
                resultSet.getTimestamp("created_at"),
                resultSet.getTimestamp("updated_at"),
                resultSet.getString("url"),
                resultSet.getString("local_path")
        );

        return contentElement;
    }
}
