package se.iths.rest;

import se.iths.entity.Student;
import se.iths.entity.Teacher;
import se.iths.service.TeacherService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Set;

@Path("teacher/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TeacherRest {

    @Inject
    TeacherService teacherService;


    @Path("getAll")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public List<Student> getAllTeachers() {
        return teacherService.getAllTeachers();
    }


    @Path("getusersforitem/{teacherName}/{subjectname}")
    @GET
    public Set<Student> getSpecificUsersForItem(@PathParam("teacherName") String buyerName, @PathParam("subjectname") String itemName) {
        return teacherService.getSpeceficStudentForSubject("teacherName","subjectname");
    }
}
