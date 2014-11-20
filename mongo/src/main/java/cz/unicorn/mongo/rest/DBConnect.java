package cz.unicorn.mongo.rest;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;
import com.mongodb.util.JSON;

public class DBConnect implements DbUtil {
	
	private static DBConnect instance;
	
	private final int PAGE_SIZE = 10;

	public String getCandidates() throws Exception {
		List<DBObject> candidates = new ArrayList<DBObject>();
		DBCursor cursor = getCol().find();
		try {
			while (cursor.hasNext()) {
				DBObject cur = cursor.next();
				candidates.add(cur);
			}
		} catch (Exception e) {
			throw new DBException("Err connecting DB.");
		} finally {
			cursor.close();
		}
		
		return JSON.serialize(candidates);		
	}

	public void addCandidate(String data) throws Exception {
		DBObject can = getDBO(data);
		
		getCol().insert(can);
		
	}

	public void editCandidate(String id, String data) throws Exception{

		DBCollection collection = getCol();
		
		DBObject candidateToUpdate = getDBO(data);
		
		collection.update(new BasicDBObject("_id", new ObjectId(id)), candidateToUpdate);
		
	}

	public void removeCandidate(String id) throws Exception {
	WriteResult wr = getCol().remove(new BasicDBObject("_id", new ObjectId(id)));
	  if (wr.getN()!= 1) {
		  throw new Exception("err");
	  }
		
	}

	public void addEvaluation(String id) throws Exception {
		DBObject db = getDBOID(id);
		Integer r = Integer.parseInt((String) db.get("rating"));
		r++;
		getCol().update(new BasicDBObject("_id", new ObjectId(id)), new BasicDBObject("$set", new BasicDBObject("rating", r)));
		
	}

	public String getCandidate(String id) {		
		DBObject candidate = getDBOID(id);
		return JSON.serialize(candidate);
	}
	
	private DB getDB() {
		MongoClient client = null;
		try {
			client = new MongoClient();
		} catch (UnknownHostException e) {
			throw new DBException("Err connecting DB.");
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
			throw new DBException("JSON err");
		}
		if (!checkCand(db)) {
			throw new DBException("JSON err");
		}
		return db;
	}
	
	private Candidate getCanFromDBO(DBObject db) throws Exception {
		return new Candidate(db.get("_id").toString(), (String) db.get("name"),(String) db.get("surname"),(String) db.get("age"),(String) db.get("height"),(String) db.get("weight"),(String) db.get("rating"));
	}
	
	private DBObject getDBOID(String id) {
		DBObject db = getCol().findOne(new BasicDBObject("_id", new ObjectId(id)));
		return db;
	}
	
	private boolean checkCand(DBObject db) {
		if(db.get("name")==null) {
			return false;
		}
		if(db.get("surname")==null) {
			return false;
		}
		if(db.get("age")==null) {
			return false;
		}
		if(db.get("height")==null) {
			return false;
		}
		if(db.get("weight")==null) {
			return false;
		}
		
		return true;
	}

	public static DbUtil getInstance() {
		if (instance == null) {
			instance = new DBConnect();
		}
		return instance;
	}


	public Candidate getCandidateObj(String id) throws Exception {
		return getCanFromDBO(getDBOID(id));
	}


	public List<Candidate> getCandidatesList() throws Exception {
		List<Candidate> candidates = new ArrayList<Candidate>();
		DBCursor cursor = getCol().find();
		try {
			while (cursor.hasNext()) {
				DBObject cur = cursor.next();
				candidates.add(getCanFromDBO(cur));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			cursor.close();
		}
		return candidates;
	}
	
	public List<Candidate> getCandidatesPage(int order) throws Exception {
		List<Candidate> candidates = new ArrayList<Candidate>();
		DBCursor cursor = getCol().find().skip((order-1)*PAGE_SIZE).limit(PAGE_SIZE);		
		
		try {
			while (cursor.hasNext()) {
				DBObject cur = cursor.next();
				System.out.println(cur);
				candidates.add(getCanFromDBO(cur));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			cursor.close();
		}
		return candidates;
	}
	
}
