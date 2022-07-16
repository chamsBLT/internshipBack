package org.acme.Controllers;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.acme.Entities.Intern;
import org.acme.Services.InternIService;

@Path("/internship-app/interns")
public class InternController {
    private final InternIService internIService;

    @Inject
    public InternController (InternIService internIService) {
        this.internIService = internIService;
    }

    @GET
    public List<Intern> getInterns() {
        return internIService.retrieveInterns();
    }

    @GET
    @Path("/getIntern/{id}")
    public Intern getIntern(@PathParam("id") Long id) {
        return internIService.getInternById(id);
    }

    @POST
    @Path("/addIntern")
    public Intern createIntern(@Valid Intern i) {
        return internIService.addIntern(i);
    }
    
    @DELETE
    @Path("/deleteIntern/{id}")
    public Response deleteIntern(@PathParam("id") Long id) {
        internIService.removeIntern(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
    
    @PUT
    @Path("/updateIntern/{id}")
    public Intern updateIntern(@PathParam("id") Long id, @Valid Intern i) {
        return internIService.updateIntern(id, i);
    }
    
    @PUT
    @Path("/affectSubject/{idi}/{ids}")
    public Intern affectSubject(@PathParam("idi") Long idi, @PathParam("ids") Long ids) {
        return internIService.affectSubject(idi,ids);
    }
    
    @PUT
    @Path("/unaffectSubject/{idi}")
    public Intern unaffectSubject(@PathParam("idi") Long idi) {
        return internIService.unaffectSubject(idi);
    }

}
