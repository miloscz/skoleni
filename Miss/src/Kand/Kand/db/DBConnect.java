package Kand.Kand.db;

import java.net.UnknownHostException;
import java.util.List;

import javax.ws.rs.core.Response;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;
import com.mongodb.util.JSON;

public class DBConnect implements DbUtil {
	
	private static DBConnect instance;

	public String getCandidates() {
		// TODO Auto-generated method stub
		return null;
	}

	public void addCandidate(String data) throws Exception {
		DBObject can = getDBO(data);
		getCol().insert(can);
		
	}

	public void editCandidate(String id, String data) {
		// TODO Auto-generated method stub
		
	}

	public void removeCandidate(String id) throws Exception {
	WriteResult wr = getCol().remove(new BasicDBObject("_id", new ObjectId(id)));
	  if (wr.getN()!= 1) {
		  throw new Exception("err");
	  }
		
	}

	public void addEvaluation(String id) throws Exception {
		DBObject db = getDBOID(id);
		Integer r = Integer.parseInt((String) db.get("raiting"));
		r++;
		getCol().update(new BasicDBObject("_id", new ObjectId(id)), new BasicDBObject("raiting", r));
		
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
	
	private DBCollection getCol() {
		return getDB().getCollection("candidates");
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
	
	private Candidate getCanFromDBO(DBObject db) throws Exception {
		return new Candidate((String) db.get("name"),(String) db.get("surname"),(String) db.get("age"), null,(String) db.get("heigh"),(String) db.get("weight"),(String) db.get("raiting"));
	}
	
	private DBObject getDBOID(String id) {
		DBObject db = getCol().findOne(new BasicDBObject("_id", new ObjectId(id)));
		return db;
	}
	
	private boolean checkCand(DBObject db) {
		// TODO Auto-generated method stub
		return true;
	}

	public static DbUtil getInstance() {
		if (instance == null) {
			instance = new DBConnect();
		}
		return instance;
	}

	@Override
	public Candidate getCandidatesObj() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Candidate> getCandidatesList() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}



}
