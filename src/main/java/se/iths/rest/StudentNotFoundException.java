package se.iths.rest;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class StudentNotFoundException  extends WebApplicationException {
    public StudentNotFoundException(Enum exceptionMessage) {
        super(Response.status(Response.Status.NOT_FOUND)
        .entity(exceptionMessage)
        .type(MediaType.TEXT_PLAIN)
        .build());
    }
}
