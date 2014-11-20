package cz.unicorn.mongo.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;


@Path("/")
public class Rest {

	DbUtil rest = DBConnect.getInstance();
	
	@GET
	@Path("/candidates")
	@Produces("application/json")
	public Response getCandidates(){
		
		String candidates;
		try{
		candidates = rest.getCandidates();
			
		}
		catch(DBRequestException e){
			return Response.status(400).entity(e.getMessage()).build();
		}
		catch(DBServerException e)
		{
			return Response.status(500).entity(e.getMessage()).build();
		}
		
		return Response.status(200).header("charset", "UTF-8").entity(candidates).build();
	}
	
	@GET
	@Path("/candidate/{CANDIDATE_ID}")
	@Produces("application/json")
	public Response getCandidate(@PathParam("CANDIDATE_ID") String id)
	{String candidate;
		try{		
		 candidate = rest.getCandidate(id);
		}
		catch(DBRequestException e){
			return Response.status(400).entity(e.getMessage()).build();
		}
		catch(DBServerException e)
		{
			return Response.status(500).entity(e.getMessage()).build();
		}
		return Response.status(200).entity(candidate).build();
	}
	
	@POST
	@Consumes("application/json")
	@Path("/candidate/create")
	public Response addCandidate(String data){
		
		try{
			rest.addCandidate(data);
		}catch(DBRequestException e){
			return Response.status(400).entity(e.getMessage()).build();
		}
		catch(DBServerException e)
		{
			return Response.status(500).entity(e.getMessage()).build();
		}
		
		
		return Response.status(200).build();
	}
	
	
	@POST
	@Path("/candidate/{CANDIDATE_ID}/edit")
	@Consumes("application/json")
	public Response editCandidate(@PathParam("CANDIDATE_ID") String idCandidate , String data){
		
		try{
			rest.editCandidate(idCandidate ,data);
		}catch(DBRequestException e){
			return Response.status(400).entity(e.getMessage()).build();
		}
		catch(DBServerException e)
		{
			return Response.status(500).entity(e.getMessage()).build();
		}
		
		
		return Response.status(200).build();
	}
	
	@POST
	@Path("/candidate/{CANDIDATE_ID}/remove")
	@Consumes("application/json")
	public Response removeCandidate(@PathParam("CANDIDATE_ID") String idCandidate){
		
		try{
			rest.removeCandidate(idCandidate);
		}catch(DBRequestException e){
			return Response.status(400).entity(e.getMessage()).build();
		}
		catch(DBServerException e)
		{
			return Response.status(500).entity(e.getMessage()).build();
		}
		
		return Response.status(200).build();
	}
	
	
	@POST
	@Path("/candidate/{CANDIDATE_ID}/evaluation/add")
	public Response addEvaluation(@PathParam("CANDIDATE_ID") String idCandidate){
		
		try{
			rest.addEvaluation(idCandidate);
		}catch(DBRequestException e){
			return Response.status(400).entity(e.getMessage()).build();
		}
		catch(DBServerException e)
		{
			return Response.status(500).entity(e.getMessage()).build();
		}
		
		
		return Response.status(200).build();
	}
	
	
	
	
	
}
