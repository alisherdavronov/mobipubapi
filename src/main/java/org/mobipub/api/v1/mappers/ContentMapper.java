package org.mobipub.api.v1.mappers;


import org.mobipub.api.v1.models.Content;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ContentMapper implements ResultSetMapper<Content> {

    @Override
    public Content map(int i, ResultSet r, StatementContext c) throws SQLException {

        Content content = new Content(
            r.getInt("id"),
            r.getInt("category_id"),
            r.getString("name"),
            r.getString("full_name"),
            r.getString("description"),
            r.getBoolean("published"),
            r.getString("access_type"),
            r.getBoolean("is_paid"),
            r.getBigDecimal("cost"),
            r.getString("currency"),
            r.getTimestamp("exported_at"),
            r.getTimestamp("created_at"),
            r.getTimestamp("updated_at")
        );

        return content;
    }
}
