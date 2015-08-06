package org.mobipub.api.v1.resources;

import org.mobipub.api.v1.dao.MobileUserFormDataDAO;
import org.mobipub.api.v1.forms.MobileUserFormDataForm;
import org.mobipub.api.v1.models.MobileUserFormData;
import org.mobipub.api.v1.utils.Authorize;
import com.yammer.metrics.annotation.Timed;
import org.skife.jdbi.v2.sqlobject.Transaction;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

@Path("/v1/mobile_user/set_form_data")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Consumes(MediaType.APPLICATION_JSON)
public class MobileUserSetFormDataResource {
    private final Authorize authorize;
    private final MobileUserFormDataDAO mobileUserFormDataDAO;

    public MobileUserSetFormDataResource(Authorize authorize, MobileUserFormDataDAO mobileUserFormDataDAO) {
        this.authorize = authorize;
        this.mobileUserFormDataDAO = mobileUserFormDataDAO;
    }

    @Transaction
    @Timed
    @POST
    public boolean create(@HeaderParam("X-Auth-Token") String token,
                          @Valid MobileUserFormDataForm mobileUserFormDataForm) {
        authorize.authorizeByBaseId(token, mobileUserFormDataForm.getBaseId());

        int mobileUserId = mobileUserFormDataForm.getMobileUserId();

        if(mobileUserId <= 0) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }

        Timestamp now = new Timestamp(new Date().getTime());
        UUID dataUUID = UUID.randomUUID();
        boolean success = true;

        for(Map.Entry<String, String> entry : mobileUserFormDataForm.getData().entrySet()) {

            MobileUserFormData mobileUserFormData = new MobileUserFormData(
                    0,
                    mobileUserId,
                    mobileUserFormDataForm.getBaseId(),
                    mobileUserFormDataForm.getFormName(),
                    dataUUID,
                    entry.getKey(),
                    entry.getValue(),
                    now,
                    now
            );

            int rowsAffected = mobileUserFormDataDAO.create(mobileUserFormData);
            if (rowsAffected != 1) {
                throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
            }
        }

        return true;
    }
}
