package Kand.Kand.db;

public interface DbUtil {
	public List<Candidate> getCandidates();
	
	public Candidate getCandidate(String id);
	
	public void addCandidate(String data);
	
	public void editCandidate(String id, String data);
	
	public void removeCandidate(String id);	
	
	public void addEvaluation(String id, String data);
}
