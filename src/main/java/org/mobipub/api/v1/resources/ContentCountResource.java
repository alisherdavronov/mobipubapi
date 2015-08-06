package org.mobipub.api.v1.resources;

import org.mobipub.api.v1.dao.ContentDAO;
import org.mobipub.api.v1.utils.Authorize;
import com.yammer.metrics.annotation.Timed;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/v1/categories/{category_id}/contents_count")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class ContentCountResource {
    private final Authorize authorize;
    private final ContentDAO dao;

    public ContentCountResource(Authorize authorize, ContentDAO dao) {
        this.authorize = authorize;
        this.dao = dao;
    }

    @Timed
    @GET
    public int getCount(@HeaderParam("X-Auth-Token") String token,
                        @PathParam("category_id") int categoryId) {
        authorize.authorizeByCategoryId(token, categoryId);

        int count = dao.countByCategoryId(categoryId);
        return count;
    }
}
