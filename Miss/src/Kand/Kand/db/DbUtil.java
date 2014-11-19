package Kand.Kand.db;

public interface DbUtil {
	
	public DbUtil getInstance();
	
	public String getCandidates() throws Exception;
	
	public String getCandidate(String id) throws Exception;
	
	public Candidate getCandidatesObj() throws Exception;
	
	public <List>Candidate getCandidatesList() throws Exception;
	
	public void addCandidate(String data) throws Exception;
	
	public void editCandidate(String id, String data) throws Exception;
	
	public void removeCandidate(String id) throws Exception;	
	
	public void addEvaluation(String id) throws Exception;
	
	
}
