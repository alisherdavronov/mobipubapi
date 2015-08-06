package org.mobipub.api.v1.resources;

import org.mobipub.api.v1.dao.ContentAttributeDAO;
import org.mobipub.api.v1.models.ContentAttribute;
import org.mobipub.api.v1.utils.Authorize;
import com.yammer.metrics.annotation.Timed;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/v1/contents/{content_id}/content_attributes")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class ContentAttributeListResource {
    private final Authorize authorize;
    private final ContentAttributeDAO dao;

    public ContentAttributeListResource(Authorize authorize, ContentAttributeDAO dao) {
        this.authorize = authorize;
        this.dao = dao;
    }

    @Timed
    @GET
    public List<ContentAttribute> getList(@HeaderParam("X-Auth-Token") String token,
                                          @PathParam("content_id") int contentId) {
        authorize.authorizeByContentId(token, contentId);

        List<ContentAttribute> contentAttributeList = dao.getListByContentId(contentId);
        return contentAttributeList;
    }
}
