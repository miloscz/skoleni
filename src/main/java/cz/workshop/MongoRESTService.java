package cz.workshop;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/")
public class MongoRESTService {

  @GET
  @Path("/test")
  public String testService() {
    return "<h1>This is MongoDB test service!</h1>";
  }

  @POST
  @Path("/test")
  public Response postTest(String data) {
    System.out.println("Data: " + data);
    return Response.status(200).entity("Data : " + data).build();

  }

}
