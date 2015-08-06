package org.mobipub.api.v1.mappers;

import org.mobipub.api.v1.models.UserRole;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRoleMapper implements ResultSetMapper<UserRole> {
    @Override
    public UserRole map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        UserRole userRole = new UserRole(
                resultSet.getInt("id"),
                resultSet.getInt("user_id"),
                resultSet.getInt("base_id"),
                resultSet.getString("role"),
                resultSet.getTimestamp("created_at"),
                resultSet.getTimestamp("updated_at")
        );

        return userRole;
    }
}
