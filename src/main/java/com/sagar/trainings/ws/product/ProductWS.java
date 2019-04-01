package com.sagar.trainings.ws.product;

import java.io.File;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.sagar.trainings.ws.product.dto.Product;

@Produces({ "application/xml,application/json" })
public interface ProductWS {

	@POST
	@Path("/products")
	Response add(Product product);

	@PUT
	@Path("/products")
	Response update(Product product);

	@DELETE
	@Path("/products/{id}")
	Response delete(@PathParam("id") int id);

	@GET
	@Path("/products/{id}")
	Product find(@PathParam("id") int id);
	
	@GET
    @Path("/getFile")
    @Produces("text/plain")
    public Response getFile();
}
