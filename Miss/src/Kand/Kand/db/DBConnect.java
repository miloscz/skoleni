package Kand.Kand.db;

import java.net.UnknownHostException;

import javax.ws.rs.core.Response;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;

public class DBConnect implements DbUtil {

	public String getCandidates() throws Exception {
		String candidates="";
		DBCursor cursor = getDB().getCollection("candidates").find();
		try {
			while (cursor.hasNext()) {
				DBObject cur = cursor.next();
				candidates+=cur.toString();
			}
		} catch (Exception e) {
			throw e;
		} finally {
			cursor.close();
		}
		return candidates;
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
		DBCollection candidates = getCol("candidates");

		BasicDBObject query = new BasicDBObject();
		query.put("_id", new ObjectId(id));
		DBObject candidate = candidates.findOne(query);
		return candidate.toString();
	}

	@Override
	public Candidate getCandidatesObj() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <List> Candidate getCandidatesList() {
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
		Object o = JSON.parse(data);
		DBObject db = null;
		if (o instanceof DBObject) {
			db = (DBObject) o;
		} else {
			throw new Exception("Chyba");
		}
		if (!checkCand(db)) {
			throw new Exception("Chyba");
		}
		return getCanFromDBO(db);
	}

	private Candidate getCanFromDBO(DBObject db) {
		return new Candidate(db.get("name"), db.get("surname"), db.get("age"),
				db.get("measures"), db.get("heigh"), db.get("weight"),
				db.get("raiting"));
	}

	private boolean checkCand(DBObject db) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public DbUtil getInstance() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addEvaluation(String id) throws Exception {
		// TODO Auto-generated method stub

	}

}
