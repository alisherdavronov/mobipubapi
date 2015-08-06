package org.mobipub.api.v1.mappers;

import org.mobipub.api.v1.models.BaseLang;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseLangMapper implements ResultSetMapper<BaseLang> {
    @Override
    public BaseLang map(int i, ResultSet r, StatementContext c) throws SQLException {

        BaseLang baseLang = new BaseLang(
                r.getInt("entity_id"),
                r.getInt("language_id"),
                r.getString("name"),
                r.getString("full_name"),
                r.getString("description")
        );

        return baseLang;
    }
}
