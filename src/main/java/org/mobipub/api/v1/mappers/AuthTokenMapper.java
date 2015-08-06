package org.mobipub.api.v1.mappers;

import org.mobipub.api.v1.models.AuthToken;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthTokenMapper implements ResultSetMapper<AuthToken> {
    @Override
    public AuthToken map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        AuthToken authToken = new AuthToken(
                resultSet.getInt("id"),
                resultSet.getString("token"),
                resultSet.getTimestamp("valid_until"),
                resultSet.getInt("user_id"),
                resultSet.getTimestamp("created_at"),
                resultSet.getTimestamp("updated_at")
        );

        return authToken;
    }
}
