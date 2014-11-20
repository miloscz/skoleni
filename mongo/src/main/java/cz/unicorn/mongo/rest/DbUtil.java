package cz.unicorn.mongo.rest;

import java.util.List;

import com.mongodb.gridfs.GridFSDBFile;

public interface DbUtil {
	

	
	public String getCandidates();
	
	public String getCandidate(String id);
	
	public Candidate getCandidateObj(String id);
	
	public List<Candidate> getCandidatesList();
	
	public void addCandidate(String data);
	
	public void editCandidate(String id, String data);
	
	public void removeCandidate(String id);	
	
	public void addEvaluation(String id);	
	
	public List<Candidate> getCandidatesPage(int order);
	
	public int getPagesCount();
	
	public GridFSDBFile getImage(String data);
	
}