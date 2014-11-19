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
	private static DBHandler instance;
	private DB db;

	@Override
	public List<Candidate> getCandidates() {
		DBCollection candidateCol;
		DBCursor obj = null;
		candidateCol = getDatabase().getCollection("candidate");
		obj = candidateCol.find();
		String result = obj.toString();
		obj.close();
		return CandidateFactory.parse(result);
	}

	@Override
	public void vote(String id) throws Exception {
		//TODO:
		DBCollection candidateCol = getDatabase().getCollection("candidate");
		DBObject obj = candidateCol.findOne(new BasicDBObject("_id", new ObjectId(id)));
		candidateCol.update(obj,  new BasicDBObject("$inc", "1"));
	}

	@Override
	public String getCandidate(String id) {
		DBCollection candidateCol;
		candidateCol = getDatabase().getCollection("candidate");
		DBObject obj = candidateCol.findOne(new BasicDBObject("_id", new ObjectId(id)));
		String result = obj.toString();
		return result;
	}

	@Override
	public String createCandidate(String body) throws Exception {
		DBCollection candidateCol = getDatabase().getCollection("candidate");
		BasicDBObject obj = (BasicDBObject)JSON.parse(body);
		candidateCol.insert(obj);
		candidateCol.ensureIndex(new BasicDBObject("name","1"));
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
		//TODO:
		DBCollection candidateCol = getDatabase().getCollection("candidate");
		DBObject obj = candidateCol.findOne(new BasicDBObject("_id", new ObjectId(id)));
		candidateCol.update(obj,  new BasicDBObject("$set", body));
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
