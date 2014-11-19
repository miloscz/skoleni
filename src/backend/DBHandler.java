package backend;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.entities.Candidate;
import org.entities.CandidateFactory;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;

import interfaces.IDBHandler;

public class DBHandler implements IDBHandler {
	private DBHandler instance;
	private DB db;

	@Override
	public List<Candidate> getCandidates() {
		DBCollection candidateCol;
		DBCursor obj = null;
		candidateCol = db.getCollection("candidate");
		obj = candidateCol.find();
		String result = obj.toString();
		obj.close();
		return CandidateFactory.parse(result);
	}

	@Override
	public void vote(String id) {
		//TODO:
	}

	@Override
	public Candidate getCandidate(String id) {
		DBCollection candidateCol;
		candidateCol = db.getCollection("candidate");
		DBObject obj = candidateCol.findOne(new BasicDBObject("_id", new ObjectId(id)));
		String result = obj.toString();
		return CandidateFactory.createCandidate(obj);
	}

	@Override
	public String createCandidate(String id, String body) {
		DBCollection candidateCol = db.getCollection("candidate");
		BasicDBObject obj = (BasicDBObject)JSON.parse(body);
		candidateCol.insert(obj);
		String result = obj.get("_id").toString();
		return result;
	}

	@Override
	public boolean removeCandidate(String id) {
		DBCollection candidateCol = db.getCollection("candidate");
		DBObject obj = candidateCol.findOne(new BasicDBObject("_id", new ObjectId(id)));
		candidateCol.remove(obj);
		return true;
	}

	@Override
	public Candidate updateCandidate(String id, String body) {
		//TODO:
//		DBCollection candidateCol = db.getCollection("candidate");
		DBObject obj = candidateCol.findOne(new BasicDBObject("_id", new ObjectId(id)));
//		candidateCol.update(obj, body);
//		candidateCol.remove(obj);
		return CandidateFactory.createCandidate(obj);
	}

	public DBHandler getInstance() {
		if (instance == null) {
			instance = new DBHandler();
			return instance;
		} else {
			return this.instance;
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
