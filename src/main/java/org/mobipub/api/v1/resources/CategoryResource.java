package org.mobipub.api.v1.resources;

import org.mobipub.api.v1.dao.CategoryDAO;
import org.mobipub.api.v1.models.Category;
import org.mobipub.api.v1.utils.Authorize;
import com.yammer.metrics.annotation.Timed;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/v1/categories/{category_id}")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class CategoryResource {
    private final Authorize authorize;
    private final CategoryDAO dao;

    public CategoryResource(Authorize authorize, CategoryDAO dao) {
        this.authorize = authorize;
        this.dao = dao;
    }

    @Timed
    @GET
    public Category getOne(@HeaderParam("X-Auth-Token") String token,
                           @PathParam("category_id") int categoryId) {
        authorize.authorizeByCategoryId(token, categoryId);

        Category category = dao.getById(categoryId);
        return category;
    }
}
