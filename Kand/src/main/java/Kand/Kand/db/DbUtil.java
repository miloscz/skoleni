package Kand.Kand.db;

public interface DbUtil {
	public String getCandidates();
	
	public String getCandidate(String id);
	
	public void addCandidate(String data);
	
	public void editCandidate(String id, String data);
	
	public void removeCandidate(String id);	
	
	public void addEvaluation(String id, String data);
}
