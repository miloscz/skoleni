package Kand.Kand.db;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class DBConnect implements DbUtil {

	public List<Candidate> getCandidates() {
		// TODO Auto-generated method stub
		return null;
	}

	public void addCandidate(String data) {
		// TODO Auto-generated method stub
		
	}

	public void editCandidate(String id, String data) {
		// TODO Auto-generated method stub
		
	}

	public void removeCandidate(String id) {
		// TODO Auto-generated method stub
		
	}

	public void addEvaluation(String id, String data) {
		// TODO Auto-generated method stub
		
	}

	public Candidate getCandidate(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private DB getDB() {
		MongoClient client = null;
		try {
			client = new MongoClient();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	    return client.getDB("kand");
	}
	
	private DBCollection getCol(String col) {
		return getDB().getCollection(col);
	}

}
