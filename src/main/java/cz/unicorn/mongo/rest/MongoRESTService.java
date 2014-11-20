package cz.unicorn.mongo.rest;


import java.awt.PageAttributes.MediaType;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.sun.jersey.core.header.MediaTypes;

import backend.DBHandler;
@Path("/")
public class MongoRESTService {
	@GET
	@Path("/{candidateid}")
	public Response getCandidate(@PathParam("candidateid") String id) {
		String can=null;
		try{
			can = DBHandler.getInstance().getCandidate(id);
			}catch(Exception ex){
				failServer(ex.toString());
			}
		
		return success(can);
	
	}

	@POST
	@Path("/")
	public Response createCandidate(String data) {
		System.out.println("test");
		String id = null;
		try {
			id = DBHandler.getInstance().createCandidate(data);
		} catch (Exception ex) {
			failServer(ex.toString());
		}
		return success(id);

	}
	
	@POST
	@Path("/{candidateid}")
	public Response updateCandidate(@PathParam("candidateid") String cid, String data) {
		String id = null;
		try {
			id = DBHandler.getInstance().updateCandidate(cid, data);
		} catch (Exception ex) {
			failServer(ex.toString());
		}
		return success(id);

	}
	
	@POST
	@Path("/remove/{candidateid}")
	public Response removeCandidate(@PathParam("candidateid") String cid) {
		boolean result = false;
		try {
			result = DBHandler.getInstance().removeCandidate(cid);
		} catch (Exception ex) {
			failServer(ex.toString());
		}
		
		
		
		return result? success(cid):failServer("Failed to remove candidate");

	}
	
	

	private Response failServer(String string) {
		return Response.status(500).entity(string).build();
	}

	private Response success(String s) {
		return Response.status(200).entity(s).build();
	}

}