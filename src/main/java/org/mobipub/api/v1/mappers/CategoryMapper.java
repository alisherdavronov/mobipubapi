package org.mobipub.api.v1.mappers;


import org.mobipub.api.v1.models.Category;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryMapper implements ResultSetMapper<Category> {
    @Override
    public Category map(int i, ResultSet r, StatementContext c) throws SQLException {
        Category category = new Category(
            r.getInt("id"),
            r.getInt("base_id"),
            r.getString("name"),
            r.getString("full_name"),
            r.getString("description"),
            r.getBoolean("published"),
            r.getInt("parent_id"),
            r.getInt("lft"),
            r.getInt("rgt"),
            r.getInt("depth"),
            r.getTimestamp("created_at"),
            r.getTimestamp("updated_at")
        );
        return category;
    }
}
