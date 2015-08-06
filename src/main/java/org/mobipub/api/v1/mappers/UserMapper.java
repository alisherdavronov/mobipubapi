package org.mobipub.api.v1.mappers;

import org.mobipub.api.v1.models.User;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements ResultSetMapper<User> {
    @Override
    public User map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        User user = new User(
                resultSet.getInt("id"),
                resultSet.getString("email"),
                resultSet.getString("encrypted_password"),
                resultSet.getBoolean("admin"),
                resultSet.getString("reset_password_token"),
                resultSet.getTimestamp("reset_password_sent_at"),
                resultSet.getTimestamp("remember_created_at"),
                resultSet.getInt("sign_in_count"),
                resultSet.getTimestamp("current_sign_in_at"),
                resultSet.getTimestamp("last_sign_in_at"),
                resultSet.getString("current_sign_in_ip"),
                resultSet.getString("last_sign_in_ip"),
                resultSet.getString("access_token"),
                resultSet.getInt("base_id"),
                resultSet.getString("guid"),
                resultSet.getString("app_id"),
                resultSet.getTimestamp("expire_at"),
                resultSet.getTimestamp("created_at"),
                resultSet.getTimestamp("updated_at"),
                resultSet.getString("confirmation_token"),
                resultSet.getString("unconfirmed_email"),
                resultSet.getTimestamp("confirmed_at"),
                resultSet.getTimestamp("confirmation_sent_at"),
                resultSet.getString("locale")
        );

        return user;
    }
}
