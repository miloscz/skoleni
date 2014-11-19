package Kand.Kand.db;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;

public class DBConnect implements DbUtil {

	public String getCandidates() {
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

	public String getCandidate(String id) {
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
	
	private Candidate getCandFromJson(String data) throws Exception {
		Object o  = JSON.parse(data);
		DBObject db = null;
		if (o instanceof DBObject) {
			db = (DBObject) o;
		}
		if (!checkCand(db)) {
			throw new Exception("Chyba");
		}
		return getCandFromDB(db);
		
	}
	
	private Candidate getCandFromDB(DBObject o) {
		List<Integer> raitings = new ArrayList<Integer>();
		return new Candidate(o.get("name"), o.get("surname"), o.get("age"), o.get("measures"), o.get("heigh"), o.get("weigh"), raitings);
	}
	


	private boolean checkCand(DBObject db) {
		// TODO Auto-generated method stub
		return true;
	}

}
