package cz.unicorn.mongo.rest;

import java.util.List;

public interface DbUtil {
	

	
	public String getCandidates() throws Exception;
	
	public String getCandidate(String id) throws Exception;
	
	public Candidate getCandidateObj(String id) throws Exception;
	
	public List<Candidate> getCandidatesList() throws Exception;
	
	public void addCandidate(String data) throws Exception;
	
	public void editCandidate(String id, String data) throws Exception;
	
	public void removeCandidate(String id) throws Exception;	
	
	public void addEvaluation(String id) throws Exception;	
	
	public List<Candidate> getCandidatesPage(int order) throws Exception;
	
	public int getPagesCount();
	
}