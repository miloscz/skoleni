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

	public void addCandidate(String data) throws Exception {
		DBObject can = getDBO(data);
		
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
	
	private Candidate getCandJSON(String data) throws Exception {	
		return getCanFromDBO(getDBO(data));
	}
	
	private DBObject getDBO(String data) throws Exception {
		Object o  = JSON.parse(data);
		DBObject db = null;
		if (o instanceof DBObject) {
			db = (DBObject) o;
		} else {
			throw new Exception("Chyba");
		}
		if (!checkCand(db)) {
			throw new Exception("Chyba");
		}
		return db;
	}
	
	private Candidate getCanFromDBO(DBObject db) {
		return new Candidate((String) db.get("name"),(String) db.get("surname"),(String) db.get("age"),(String) db.get("measures"),(String) db.get("heigh"),(String) db.get("weight"),(String) db.get("raiting"));
	}
	

	private boolean checkCand(DBObject db) {
		// TODO Auto-generated method stub
		return true;
	}

}
