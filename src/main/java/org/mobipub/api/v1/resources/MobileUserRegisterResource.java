package org.mobipub.api.v1.resources;

import org.mobipub.api.v1.dao.MobileUserDAO;
import org.mobipub.api.v1.forms.LoginForm;
import org.mobipub.api.v1.models.MobileUser;
import org.mobipub.api.v1.utils.Authorize;
import com.yammer.metrics.annotation.Timed;
import org.mindrot.jbcrypt.BCrypt;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.Timestamp;
import java.util.Date;

@Path("/v1/mobile_user/register")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Consumes(MediaType.APPLICATION_JSON)
public class MobileUserRegisterResource {
    private final Authorize authorize;
    private final MobileUserDAO mobileUserDAO;

    public MobileUserRegisterResource(Authorize authorize, MobileUserDAO mobileUserDAO) {
        this.authorize = authorize;
        this.mobileUserDAO = mobileUserDAO;
    }

    @Timed
    @POST
    public MobileUser register(@HeaderParam("X-Auth-Token") String token,
                               @Valid LoginForm loginForm) {
        authorize.authorizeByBaseId(token, loginForm.getBaseId());

        Timestamp now = new Timestamp(new Date().getTime());

        String salt = BCrypt.gensalt();
        String passwordHash = BCrypt.hashpw(loginForm.getPassword(), salt);

        MobileUser mobileUser = new MobileUser(
                0,
                loginForm.getBaseId(),
                loginForm.getEmail(),
                passwordHash,
                now,
                now);

        int rowsAffected = mobileUserDAO.create(mobileUser);

        if (rowsAffected != 1) throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);

        mobileUser = mobileUserDAO.getByEmailAndBaseId(mobileUser.getEmail(), mobileUser.getBaseId());

        return mobileUser;
    }
}
