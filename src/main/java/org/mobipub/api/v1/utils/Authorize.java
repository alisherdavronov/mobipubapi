package org.mobipub.api.v1.utils;

import org.mobipub.api.v1.dao.*;
import org.mobipub.api.v1.forms.LoginForm;
import org.mindrot.jbcrypt.BCrypt;
import org.mobipub.api.v1.models.*;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

public class Authorize {

    private final AuthTokenDAO authTokenDAO;
    private final UserDAO userDAO;
    private final UserRoleDAO userRoleDAO;
    private final int tokenTimeout;

    private final CategoryDAO categoryDAO;
    private final ContentDAO contentDAO;


    public Authorize(
            AuthTokenDAO authTokenDAO, UserDAO userDAO, UserRoleDAO userRoleDAO, int tokenTimeout,
            CategoryDAO categoryDAO, ContentDAO contentDAO) {
        this.authTokenDAO = authTokenDAO;
        this.userDAO = userDAO;
        this.userRoleDAO = userRoleDAO;
        this.tokenTimeout = tokenTimeout;
        this.categoryDAO = categoryDAO;
        this.contentDAO = contentDAO;
    }

    public static void unauthorized() {
        throw new WebApplicationException(Response.Status.UNAUTHORIZED);
    }

    public String login(LoginForm loginForm) {

        User user = userDAO.getByEmail(loginForm.getEmail());
        if (user == null) unauthorized();  //TODO "User not found error" must me implemented

        if (!BCrypt.checkpw(loginForm.getPassword(), user.getEncryptedPassword())) unauthorized();

        UserRole userRole = userRoleDAO.getByUserAndBaseId(user.getId(), loginForm.getBaseId());
        if (userRole == null) unauthorized();  //TODO "User access denied" must me implemented

        final String token = UUID.randomUUID().toString();
        final Timestamp now = new Timestamp(new Date().getTime());
        final Timestamp validUntil = new Timestamp(new Date().getTime() + tokenTimeout * 60000);
        AuthToken authToken = new AuthToken(0, token, validUntil, user.getId(), now, now);

        final int rowsAffected = authTokenDAO.create(authToken);
        if (rowsAffected != 1) {
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }

        return authToken.getToken();
    }

    private AuthToken authenticate(String token) {
        if (token == null) unauthorized();

        final Timestamp now = new Timestamp(new Date().getTime());

        AuthToken authToken = authTokenDAO.getByToken(token);
        if (authToken == null) unauthorized();

        if (authToken.getValidUntil().getTime() < now.getTime()) unauthorized();

        //prolong token timeout
        final Timestamp validUntil = new Timestamp(now.getTime() + tokenTimeout * 60000);

        authToken = new AuthToken(
                authToken.getId(),
                token,
                validUntil,
                authToken.getUserId(),
                authToken.getCreatedAt(),
                now
        );

        final int rowsAffected = authTokenDAO.update(authToken);
        if (rowsAffected != 1) {
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }

        return authToken;
    }

    public String authorizeByBaseId(String token, int baseId) {
        final AuthToken authToken = authenticate(token);

        UserRole userRole = userRoleDAO.getByUserAndBaseId(authToken.getUserId(), baseId);
        if (userRole == null) unauthorized();

        return userRole.getRole();
    }

    public String authorizeByCategoryId(String token, int categoryId) {
        authenticate(token);

        Category category = categoryDAO.getById(categoryId);
        if (category == null) unauthorized();

        return authorizeByBaseId(token, category.getBaseId());
    }

    public String authorizeByContentId(String token, int contentId) {
        authenticate(token);

        Content content = contentDAO.getById(contentId);
        if (content == null) unauthorized();

        return authorizeByCategoryId(token, content.getCategoryId());
    }
}
