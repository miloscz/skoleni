package kand.kand.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/")
public class Rest {

	TestRest rest = new TestRest();
	
	@GET
	@Path("/api/candidates")
	@Consumes("application/json")
	@Produces("application/json")
	public Response getCandidates(){
		
		String candidates;
		try{
		candidates = rest.getCandidates();
			
		}
		catch(Exception e){
			return Response.status(400).build();
		}
		
		return Response.status(200).entity(candidates).build();
	}
	
	@POST
	@Path("/api/candidate/{CANTIDATE_ID}")
	@Produces("application/json")
	public Response getCandidate(@PathParam("CANDIDATE_ID") String id)
	{String candidate;
		try{
		
		 candidate = rest.getCandidate(id);
		}
		catch(Exception e){
			return Response.status(400).build();
		}
		return Response.status(200).entity(candidate).build();
	}
	
	@POST
	@Consumes("application/json")
	@Path("/api/candidate/create")
	public Response addCandidate(String data){
		
		try{
			rest.addCandidate(data);
		}catch(Exception e){
			return Response.status(400).build();
		}
		
		
		return Response.status(200).build();
	}
	
	
	@POST
	@Path("/api/candidate/{CANDIDATE_ID}/edit")
	@Consumes("application/json")
	public Response editCandidate(@PathParam("CANDIDATE_ID") String idCandidate , String data){
		
		try{
			rest.editCandidate(idCandidate ,data);
		}catch(Exception e){
			return Response.status(400).build();
		}
		
		
		return Response.status(200).build();
	}
	
	@POST
	@Path("/api/candidate/{CANDIDATE_ID}/remove")
	@Consumes("application/json")
	public Response removeCandidate(@PathParam("CANDIDATE_ID") String idCandidate){
		
		try{
			rest.removeCandidate(idCandidate);
		}catch(Exception e){
			return Response.status(400).build();
		}
		
		
		return Response.status(200).build();
	}
	
	
	@POST
	@Path("/api/candidate/{CANDIDATE_ID}/evaluation/add")
	@Consumes("application/json")
	public Response addEvaluation(@PathParam("CANDIDATE_ID") String idCandidate, String data){
		
		try{
			rest.addEvaluation(idCandidate);
		}catch(Exception e){
			return Response.status(400).build();
		}
		
		
		return Response.status(200).build();
	}
	
	
	
	
	
}
