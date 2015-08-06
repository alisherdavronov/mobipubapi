package org.mobipub.api.v1.resources;

import org.mobipub.api.v1.dao.ContentDAO;
import org.mobipub.api.v1.models.Content;
import org.mobipub.api.v1.utils.Authorize;
import com.yammer.metrics.annotation.Timed;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/v1/categories/{category_id}/contents/{offset}/{limit}")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class ContentListResource {
    private final Authorize authorize;
    private final ContentDAO dao;

    public ContentListResource(Authorize authorize, ContentDAO dao) {
        this.authorize = authorize;
        this.dao = dao;
    }

    @Timed
    @GET
    public List<Content> getList(@HeaderParam("X-Auth-Token") String token,
                                 @PathParam("category_id") int categoryId, @PathParam("offset") int offset, @PathParam("limit") int limit) {
        authorize.authorizeByCategoryId(token, categoryId);

        List<Content> contentList = dao.getPagedList(categoryId, offset, limit);
        return contentList;
    }
}
