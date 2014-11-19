package interfaces;

import java.util.List;

import org.entities.Candidate;

public interface IDBHandler {
	public List<Candidate> getCandidates();
public void vote(String id);
public Candidate getCandidate(String id);
public String createCandidate(String id, String body);
public boolean removeCandidate(String id);
public Candidate updateCandidate(String id, String body);
}
