package org.mobipub.api.v1.resources;

import org.mobipub.api.v1.dao.BaseDAO;
import org.mobipub.api.v1.models.Base;
import com.yammer.metrics.annotation.Timed;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/v1/bases/{base_id}")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class BaseResource {
    private final BaseDAO dao;

    public BaseResource(BaseDAO dao) {
        this.dao = dao;
    }

    @Timed
    @GET
    public Base getOne(@PathParam("base_id") int baseId) {
        Base base = dao.getById(baseId);
        return base;
    }
}
