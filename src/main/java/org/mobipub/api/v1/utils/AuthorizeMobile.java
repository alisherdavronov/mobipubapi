package org.mobipub.api.v1.utils;

import org.mobipub.api.v1.dao.MobileUserDAO;
import org.mobipub.api.v1.forms.LoginForm;
import org.mobipub.api.v1.models.MobileUser;
import org.mindrot.jbcrypt.BCrypt;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class AuthorizeMobile {

    private final MobileUserDAO mobileUserDAO;

    public AuthorizeMobile(MobileUserDAO mobileUserDAO) {
        this.mobileUserDAO = mobileUserDAO;
    }

    public static void unauthorized() {
        throw new WebApplicationException(Response.Status.UNAUTHORIZED);
    }

    public MobileUser login(LoginForm loginForm) {

        MobileUser mobileUser = mobileUserDAO.getByEmailAndBaseId(loginForm.getEmail(), loginForm.getBaseId());

        if (mobileUser == null) unauthorized(); //TODO "User not found error" must me implemented

        if (!BCrypt.checkpw(loginForm.getPassword(), mobileUser.getPasswordHash())) unauthorized();

        return mobileUser;
    }
}
