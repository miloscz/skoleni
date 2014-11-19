package Kand.Kand.rest;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

public class Rest {

	public Rest(){
		
	}
	
	@GET
	@Path("/api/candidates")
	public Response getCandidates()
	{
		try{
		// /String candidates = XXX.getCandidates();
			
		}
		catch(Exception e){
			return Response.status(400).build();
		}
		
		return Response.status(200).entity(candidates).build;
	}
	
	@POST
	@Path("/api/candidate/{CANTIDATE_ID}")
	public Response getCandidate(@PathParam("CANDIDATE_ID") String id)
	{
		try{
		
		//String candidate = XXX.getCandidate(id);
		}
		catch(Exception e){
			return Response.status(400).build();
		}
		return Response.status(200).entity(json).build;
	}
	
	@POST
	@Path("/api/candidate/create")
	public Response addCandidate(String data){
		
		try{
			xxx.addCandidate(data);
		}catch(Exception e){
			return Response.status(400).build();
		}
		
		
		return Response.status(200).build();
	}
	
	
	@POST
	@Path("/api/candidate/{CANDIDATE_ID}/edit")
	public Response editCandidate(@PathParam("CANDIDATE_ID") String idCandidate , String data){
		
		try{
			xxx.editCandidate(idCandidate ,data);
		}catch(Exception e){
			return Response.status(400).build();
		}
		
		
		return Response.status(200).build();
	}
	
	@POST
	@Path("/api/candidate/{CANDIDATE_ID}/remove")
	public Response removeCandidate(@PathParam("CANDIDATE_ID") String idCandidate){
		
		try{
			xxx.removeCandidate(idCandidate);
		}catch(Exception e){
			return Response.status(400).build();
		}
		
		
		return Response.status(200).build();
	}
	
	
	@POST
	@Path("/api/candidate/{CANDIDATE_ID}/evaluation/add")
	public Response removeCandidate(@PathParam("CANDIDATE_ID") String idCandidate){
		
		try{
			xxx.removeCandidate(idCandidate);
		}catch(Exception e){
			return Response.status(400).build();
		}
		
		
		return Response.status(200).build();
	}
	
	
	
	
	
}
