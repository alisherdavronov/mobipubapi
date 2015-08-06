package org.mobipub.api.v1.resources;

import org.mobipub.api.v1.dao.ContentElementDAO;
import org.mobipub.api.v1.models.ContentElement;
import org.mobipub.api.v1.utils.Authorize;
import com.yammer.metrics.annotation.Timed;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/v1/contents/{content_id}/content_elements")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class ContentElementListResource {
    private final Authorize authorize;
    private final ContentElementDAO dao;

    public ContentElementListResource(Authorize authorize, ContentElementDAO dao) {
        this.authorize = authorize;
        this.dao = dao;
    }

    @Timed
    @GET
    public List<ContentElement> getList(@HeaderParam("X-Auth-Token") String token,
                                        @PathParam("content_id") int contentId) {
        authorize.authorizeByContentId(token, contentId);

        List<ContentElement> contentElementList = dao.getListByContentId(contentId);
        return contentElementList;
    }
}