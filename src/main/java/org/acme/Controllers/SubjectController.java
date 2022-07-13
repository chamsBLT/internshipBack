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

import org.acme.Entities.Subject;
import org.acme.Services.SubjectIService;

@Path("/internship-app/subjects")
public class SubjectController {
	private final SubjectIService subjectIService;

    @Inject
    public SubjectController (SubjectIService subjectIService) {
        this.subjectIService = subjectIService;
    }

    @GET
    public List<Subject> getSubjects() {
        return subjectIService.retrieveSubjects();
    }

    @GET
    @Path("/getSubject/{id}")
    public Subject getSubject(@PathParam("id") Long id) {
        return subjectIService.getSubjectById(id);
    }

    @POST
    @Path("/addSubject")
    public Subject createSubject(@Valid Subject s) {
        return subjectIService.addSubject(s);
    }
    
    @DELETE
    @Path("/deleteSubject/{id}")
    public Response deleteSubject(@PathParam("id") Long id) {
        subjectIService.removeSubject(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
    
    @PUT
    @Path("/updateSubject/{id}")
    public Subject updateSubject(@PathParam("id") Long id, @Valid Subject s) {
        return subjectIService.updateSubject(id, s);
    }
    
}
