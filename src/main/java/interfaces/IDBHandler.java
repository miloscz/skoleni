package interfaces;

import java.util.List;

import org.entities.Candidate;

public interface IDBHandler  {
public List<Candidate> getCandidates() throws Exception;
public void vote(String id) throws Exception;
public String getCandidate(String id) throws Exception;
public List<Candidate> getCandidates(int count, int page) throws Exception;
public String createCandidate(String body) throws Exception;
public boolean removeCandidate(String id) throws Exception;
public String updateCandidate(String id, String body) throws Exception;
}
