package se.iths.rest;

import se.iths.entity.Student;
import se.iths.service.StudentService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("student")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StudentRest {

    @Inject
    StudentService studentService;

    public Response getResponseOrException(Student student, Enum exceptionMessage){
        if (student != null)return Response.ok(student).build();
        throw new StudentNotFoundException(exceptionMessage);
    }


    @Path("add")
    @POST
    public Response addStudent(Student student) {
        studentService.createStudent(student);
        return Response.ok().build();

    }

    @Path("getAll")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public List<Student> get() {
        return studentService.getAllStudents();
    }

    @Path("get/{id}")
    @GET
    public Response getStudentById(@PathParam("id") Long id){
        return getResponseOrException(studentService.findStudentById(id),ExceptionMessages.Invalid_Student_ID);

    }


        /*
        if (studentFoundById != null)return Response.ok(studentFoundById).build();
        throw new StudentNotFoundException(ExceptionMessages.Invalid_Student_ID);
        */

}
