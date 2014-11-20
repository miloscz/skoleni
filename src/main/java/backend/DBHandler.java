package backend;

import interfaces.IDBHandler;

import java.net.UnknownHostException;
import java.util.List;

import org.bson.types.ObjectId;
import org.entities.Candidate;
import org.entities.CandidateFactory;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;
import com.mongodb.util.JSON;

public class DBHandler implements IDBHandler {
	private static DBHandler instance;
	private DB db;
	private DBHandler(){};

	
	@Override
	public List<Candidate> getCandidates() throws UnknownHostException {
		DBCollection candidateCol;
		DBCursor obj = null;
		candidateCol = getDatabase().getCollection("candidate");
		obj = candidateCol.find();
		obj.close();
		return CandidateFactory.createList(obj);
	}
	
	@Override
	public List<Candidate> getCandidates(int count, int page) throws UnknownHostException {
		DBCollection candidateCol;
		DBCursor obj = null;
		candidateCol = getDatabase().getCollection("candidate");
		obj = candidateCol.find().skip(page).limit(count);
		String result = obj.toString();
		obj.close();
		return CandidateFactory.createList(obj);
	}

	@Override
	public void vote(String id) throws Exception {
		DBCollection candidateCol = getDatabase().getCollection("candidate");
		DBObject obj = candidateCol.findOne(new BasicDBObject("_id", new ObjectId(id)));
		System.out.println(obj.toString());
		System.out.println(new BasicDBObject("$inc", new BasicDBObject("vote",1)).toString());
		WriteResult wr=candidateCol.update(obj, new BasicDBObject("$inc", new BasicDBObject("votes",1)) );
		System.out.println(wr);
		System.out.println();
	}

	@Override
	public String getCandidate(String id) throws UnknownHostException {
		DBCollection candidateCol;
		candidateCol = getDatabase().getCollection("candidate");
		DBObject obj = candidateCol.findOne(new BasicDBObject("_id", new ObjectId(id)));
		String result = obj.toString();
		return result;
	}

	@Override
	public String createCandidate(String body) throws UnknownHostException {
		DBCollection candidateCol = getDatabase().getCollection("candidate");
		BasicDBObject obj = (BasicDBObject)JSON.parse(body);
		candidateCol.insert(obj);
		candidateCol.ensureIndex(new BasicDBObject("name",false));
		String result = obj.get("_id").toString();
		return result;
	}

	@Override
	public boolean removeCandidate(String id) throws Exception {
		DBCollection candidateCol = getDatabase().getCollection("candidate");
		DBObject obj = candidateCol.findOne(new BasicDBObject("_id", new ObjectId(id)));
		candidateCol.remove(obj);
		return true;
	}

	@Override
	public String updateCandidate(String id, String body) throws Exception {
		System.out.println("HALOOO");
		DBCollection candidateCol = getDatabase().getCollection("candidate");
		System.out.println("HALOOO");
		DBObject obj = candidateCol.findOne(new BasicDBObject("_id", new ObjectId(id)));
		System.out.println("HALOOO");
		candidateCol.update(obj,  new BasicDBObject("$set", body));
		System.out.println("holaaa");
		System.out.println("HOLAAAAA"+obj.toString());
		obj = candidateCol.findOne(new BasicDBObject("_id", new ObjectId(id)));
		return obj.toString();
	}

	public static DBHandler getInstance() {
		if (instance == null) {
			instance = new DBHandler();
			return instance;
		} else {
			return instance;
		}
	}

	private DB getDatabase() throws UnknownHostException {
		if (db == null) {
			MongoClient client;
			client = new MongoClient();
			db = client.getDB("candidates");
		}
		return db;
	}
}
