package org.mobipub.api.v1.mappers;

import org.mobipub.api.v1.models.MobileUser;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MobileUserMapper implements ResultSetMapper<MobileUser> {
    @Override
    public MobileUser map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        MobileUser mobileUser = new MobileUser(
                resultSet.getInt("id"),
                resultSet.getInt("base_id"),
                resultSet.getString("email"),
                resultSet.getString("password_hash"),
                resultSet.getTimestamp("created_at"),
                resultSet.getTimestamp("updated_at")
        );

        return mobileUser;
    }
}
