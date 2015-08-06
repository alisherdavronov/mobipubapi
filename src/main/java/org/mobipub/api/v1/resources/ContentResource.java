package org.mobipub.api.v1.resources;

import org.mobipub.api.v1.dao.ContentDAO;
import org.mobipub.api.v1.models.Content;
import org.mobipub.api.v1.utils.Authorize;
import com.yammer.metrics.annotation.Timed;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/v1/contents/{content_id}")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class ContentResource {
    private final Authorize authorize;
    private final ContentDAO dao;

    public ContentResource(Authorize authorize, ContentDAO dao) {
        this.authorize = authorize;
        this.dao = dao;
    }

    @Timed
    @GET
    public Content getOne(@HeaderParam("X-Auth-Token") String token,
                          @PathParam("content_id") int contentId) {
        authorize.authorizeByContentId(token, contentId);

        Content content = dao.getById(contentId);
        return content;
    }
}
