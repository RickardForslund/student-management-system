package se.iths.rest;

import se.iths.entity.Student;
import se.iths.rest.Exceptions.ExceptionMessages;
import se.iths.rest.Exceptions.StudentNotFoundException;
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
    @Produces(MediaType.TEXT_PLAIN)
    @POST
    public Response addStudent(Student student) {
        studentService.createStudent(student);
        return Response.ok().build();

    }

    @Path("getAll")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public List<Student> get() {
        if (!studentService.getAllStudents().isEmpty())
            return studentService.getAllStudents();

        throw new StudentNotFoundException(ExceptionMessages.Cant_Find_Any_Students);


    }

    @Path("id/{id}")
    @GET
    public Response getStudentById(@PathParam("id") Long id){
        return getResponseOrException(studentService.findStudentById(id),ExceptionMessages.Invalid_Student_ID);
    }

    @Path("firstname/{firstName}")
    @GET
    public List<Student> getStudentByFirstName(@PathParam("firstName") String firstName){
        if (!studentService.findStudentByfirstName(firstName).isEmpty())
            return studentService.findStudentByfirstName(firstName);

        throw new StudentNotFoundException(ExceptionMessages.Invalid_Student_Firstname);
    }

    @Path("lastname/{lastName}")
    @GET
    public List<Student> getStudentBylastName(@PathParam("lastName") String lastName){
        if (!studentService.findStudentBylastName(lastName).isEmpty())
            return studentService.findStudentBylastName(lastName);

        throw new StudentNotFoundException(ExceptionMessages.Invalid_Student_Lastname);

    }

    @Path("update")
    @PUT
    public Response updateItem(Student student) {
        studentService.updateStudent(student);
        return Response.ok(student).build();
    }


    @Path("delete/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    @DELETE
    public Response deleteStudent(@PathParam("id") Long id) {
        Student foundStudent = studentService.findStudentById(id);
        if (foundStudent != null) {
            studentService.deleteStudent(id);
            return Response.ok().entity("Item with ID " + id + " was successfully deleted.").build();
        } else {
            throw new StudentNotFoundException(ExceptionMessages.Invalid_Student_ID);
        }
    }

}
