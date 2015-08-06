package org.mobipub.api.v1.mappers;

import org.mobipub.api.v1.models.ContentAttribute;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ContentAttributeMapper implements ResultSetMapper<ContentAttribute> {

    @Override
    public ContentAttribute map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {

        ContentAttribute contentAttribute = new ContentAttribute(
                resultSet.getInt("id"),
                resultSet.getInt("content_id"),
                resultSet.getString("name"),
                resultSet.getString("full_name"),
                resultSet.getInt("order_number"),
                resultSet.getString("lang"),
                resultSet.getString("value"),
                resultSet.getTimestamp("created_at"),
                resultSet.getTimestamp("updated_at")
        );

        return contentAttribute;
    }
}
