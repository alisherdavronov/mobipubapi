package org.mobipub.api.v1.resources;

import org.mobipub.api.v1.dao.BaseLangDAO;
import org.mobipub.api.v1.models.BaseLang;
import com.yammer.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/v1/base_langs/{base_id}")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class BaseLangResource {
    private final BaseLangDAO dao;

    public BaseLangResource(BaseLangDAO dao) {
        this.dao = dao;
    }

    @Timed
    @GET
    public List<BaseLang> getByBaseId(@PathParam("base_id") int baseId) {
        List<BaseLang> list = dao.getListByBaseId(baseId);
        return list;
    }
}
