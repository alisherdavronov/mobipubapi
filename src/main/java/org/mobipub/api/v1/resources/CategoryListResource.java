package org.mobipub.api.v1.resources;

import org.mobipub.api.v1.dao.CategoryDAO;
import org.mobipub.api.v1.models.Category;
import org.mobipub.api.v1.utils.Authorize;
import com.yammer.metrics.annotation.Timed;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/v1/bases/{base_id}/categories/{offset}/{limit}")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class CategoryListResource {
    private final Authorize authorize;
    private final CategoryDAO dao;

    public CategoryListResource(Authorize authorize, CategoryDAO dao) {
        this.authorize = authorize;
        this.dao = dao;
    }

    @Timed
    @GET
    public List<Category> getList(@HeaderParam("X-Auth-Token") String token,
                                  @PathParam("base_id") int baseId, @PathParam("offset") int offset, @PathParam("limit") int limit) {
        authorize.authorizeByBaseId(token, baseId);

        List<Category> categoryList = dao.getPagedList(baseId, offset, limit);
        return categoryList;
    }
}
