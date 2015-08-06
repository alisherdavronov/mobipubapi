package org.mobipub.api.v1.mappers;

import org.mobipub.api.v1.models.Base;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseMapper implements ResultSetMapper<Base> {
    @Override
    public Base map(int i, ResultSet r, StatementContext c) throws SQLException {

        Base base = new Base(
                r.getInt("id"),
                r.getInt("owner_id"),
                r.getInt("is_api_available"),
                r.getInt("pos"),
                r.getTimestamp("created_at"),
                r.getTimestamp("updated_at")
        );

        return base;
    }
}
