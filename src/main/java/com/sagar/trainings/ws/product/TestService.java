package com.sagar.trainings.ws.product;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import java.io.File;

@Path("/test")
public class TestService {

    @GET
    @Path("/getFile")
    @Produces("text/plain")
    public Response getFile(){
        File file = new File(System.getProperty("user.home")+"/Desktop/tmp.txt");
        ResponseBuilder response = Response.ok((Object) file);
        response.header("Content-Disposition", "attachment;filename=test.txt");
        return response.build();
    }
}

