package org.mobipub.api.v1.resources;

import org.mobipub.api.v1.dao.MobileUserAppStartDAO;
import org.mobipub.api.v1.forms.MobileUserLocationForm;
import org.mobipub.api.v1.models.MobileUserAppStart;
import org.mobipub.api.v1.utils.Authorize;
import com.yammer.metrics.annotation.Timed;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.Timestamp;
import java.util.Date;

@Path("/v1/mobile_user/set_app_start")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Consumes(MediaType.APPLICATION_JSON)
public class MobileUserSetAppStartResource {
    private final Authorize authorize;
    private final MobileUserAppStartDAO mobileUserAppStartDAO;

    public MobileUserSetAppStartResource(Authorize authorize, MobileUserAppStartDAO mobileUserAppStartDAO) {
        this.authorize = authorize;
        this.mobileUserAppStartDAO = mobileUserAppStartDAO;
    }

    @Timed
    @POST
    public boolean create(@HeaderParam("X-Auth-Token") String token,
                          @Valid MobileUserLocationForm mobileUserLocationForm) {
        authorize.authorizeByBaseId(token, mobileUserLocationForm.getBaseId());

        final Timestamp now = new Timestamp(new Date().getTime());

        int mobileUserId = mobileUserLocationForm.getMobileUserId();

        if(mobileUserId <= 0){
            mobileUserId = -1;
        }

        MobileUserAppStart mobileUserAppStart = new MobileUserAppStart(
                0,
                mobileUserId,
                mobileUserLocationForm.getBaseId(),
                mobileUserLocationForm.getDeviceId(),
                mobileUserLocationForm.getUserMarketId(),
                now,
                now
        );

        int rowsAffected = mobileUserAppStartDAO.create(mobileUserAppStart);
        return (rowsAffected == 1);
    }
}
