package Kand.Kand.db;

import java.net.UnknownHostException;

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
	
	private Candidate getCand(String data) throws Exception {
		Object o  = JSON.parse(data);
		DBObject db = null;
		if (o instanceof DBObject) {
			db = (DBObject) o;
		}
		if (!checkCand(db)) {
			throw new Exception("Chyba");
		}
		return null;
	}

	private boolean checkCand(DBObject db) {
		// TODO Auto-generated method stub
		return true;
	}

}
