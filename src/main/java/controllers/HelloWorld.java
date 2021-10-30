package controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/hello")
public class HelloWorld {
    @GET
    @Produces({MediaType.TEXT_PLAIN})
    @Path("{name}")
    public Response getMessage(@PathParam("name") String name) {
        // Return a simple message
        String output = "Hello " + name + "!";
        return Response.status(200).entity(output).build();
    }
}
