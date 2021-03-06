package se.iths.rest.Exceptions;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class StudentNotFoundException  extends WebApplicationException {
    public StudentNotFoundException(Enum exceptionMessage) {
        super(Response.status(Response.Status.NOT_FOUND)
        .entity(exceptionMessage.name())
        .type(MediaType.TEXT_PLAIN)
        .build());
    }
}
