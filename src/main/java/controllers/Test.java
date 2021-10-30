package controllers;

import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@Path("/test")
public class Test {
    @Context
    ServletContext servletContext;

    @Path("/{path: .+}")
    @GET
    @Produces({MediaType.TEXT_HTML})
    public InputStream getMessage(@PathParam("path") String path) {
        try {
            String base = servletContext.getRealPath("/WEB-INF/html");
            File f = new File(String.format("%s/%s", base, path));
            return new FileInputStream(f);
        } catch (FileNotFoundException e) {
            return null;
        }
    }
}
