package org.mobipub.api.v1.resources;

import org.mobipub.api.v1.models.MobileUser;
import org.mobipub.api.v1.forms.LoginForm;
import org.mobipub.api.v1.utils.Authorize;
import org.mobipub.api.v1.utils.AuthorizeMobile;
import com.yammer.metrics.annotation.Timed;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/v1/mobile_user/auth")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Consumes(MediaType.APPLICATION_JSON)
public class MobileUserAuthResource {
    private final Authorize authorize;
    private final AuthorizeMobile authorizeMobile;

    public MobileUserAuthResource(Authorize authorize, AuthorizeMobile authorizeMobile) {
        this.authorize = authorize;
        this.authorizeMobile = authorizeMobile;
    }

    @Timed
    @POST
    public MobileUser login(@HeaderParam("X-Auth-Token") String token,
                            @Valid LoginForm loginForm) {
        authorize.authorizeByBaseId(token, loginForm.getBaseId());
        final MobileUser mobileUser = authorizeMobile.login(loginForm);
        return mobileUser;
    }
}
