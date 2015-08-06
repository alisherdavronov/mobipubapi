package org.mobipub.api.v1.resources;

import org.mobipub.api.v1.forms.LoginForm;
import org.mobipub.api.v1.utils.Authorize;
import com.yammer.metrics.annotation.Timed;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/v1/user/auth")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Consumes(MediaType.APPLICATION_JSON)
public class UserAuthResource {

    private final Authorize authorize;

    public UserAuthResource(Authorize authorize) {
        this.authorize = authorize;
    }

    @Timed
    @POST
    public String login(@Valid LoginForm loginForm) {
        final String token = authorize.login(loginForm);
        return token;
    }
}
