package org.mobipub.api.v1.resources;

import org.mobipub.api.v1.dao.MobileUserLocationDAO;
import org.mobipub.api.v1.forms.MobileUserLocationForm;
import org.mobipub.api.v1.models.MobileUserLocation;
import org.mobipub.api.v1.utils.Authorize;
import com.yammer.metrics.annotation.Timed;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.Timestamp;
import java.util.Date;

@Path("/v1/mobile_user/set_geo_location")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Consumes(MediaType.APPLICATION_JSON)
public class MobileUserSetGeoLocationResource {
    private final Authorize authorize;
    private final MobileUserLocationDAO mobileUserLocationDAO;

    public MobileUserSetGeoLocationResource(Authorize authorize, MobileUserLocationDAO mobileUserLocationDAO) {
        this.authorize = authorize;
        this.mobileUserLocationDAO = mobileUserLocationDAO;
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

        MobileUserLocation mobileUserLocation = new MobileUserLocation(
                0,
                mobileUserId,
                mobileUserLocationForm.getBaseId(),
                mobileUserLocationForm.getDeviceId(),
                mobileUserLocationForm.getUserMarketId(),
                mobileUserLocationForm.getLat(),
                mobileUserLocationForm.getLon(),
                now,
                now
        );

        int rowsAffected = mobileUserLocationDAO.create(mobileUserLocation);
        return (rowsAffected == 1);
    }
}
