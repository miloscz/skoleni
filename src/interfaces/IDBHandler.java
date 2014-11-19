package interfaces;

import java.util.List;

import org.entities.Candidate;

public interface IDBHandler {
	public List<Candidate> getCandidates();
public void vote(String id);
public String getCandidate(String id);
public String createCandidate(String body);
public boolean removeCandidate(String id);
public String updateCandidate(String id, String body);
}
