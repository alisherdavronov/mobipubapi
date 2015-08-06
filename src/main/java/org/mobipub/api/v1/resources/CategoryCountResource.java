package org.mobipub.api.v1.resources;

import org.mobipub.api.v1.dao.CategoryDAO;
import org.mobipub.api.v1.utils.Authorize;
import com.yammer.metrics.annotation.Timed;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/v1/bases/{base_id}/categories_count")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class CategoryCountResource {
    private final Authorize authorize;
    private final CategoryDAO dao;

    public CategoryCountResource(Authorize authorize, CategoryDAO dao) {
        this.authorize = authorize;
        this.dao = dao;
    }

    @Timed
    @GET
    public int getCount(@HeaderParam("X-Auth-Token") String token,
                        @PathParam("base_id") int baseId) {
        authorize.authorizeByBaseId(token, baseId);

        int count = dao.countByBaseId(baseId);
        return count;
    }
}
