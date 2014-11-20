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
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.util.JSON;

public class DBConnect implements DbUtil {

	private static DBConnect instance;

	private final int PAGE_SIZE = 10;

	public String getCandidates() {
		List<DBObject> candidates = new ArrayList<DBObject>();
		DBCursor cursor = getCol().find();
		try {
			while (cursor.hasNext()) {
				DBObject cur = cursor.next();
				candidates.add(cur);
			}
		} catch (Exception e) {
			throw new DBServerException("Err connecting DB.");
		} finally {
			cursor.close();
		}

		return JSON.serialize(candidates);
	}

	public void addCandidate(String data) {
		DBObject can = getDBO(data);		

		WriteResult wr = getCol().insert(can);

	}

	public void editCandidate(String id, String data) {

		DBCollection collection = getCol();
		DBObject candidateToUpdate = getDBO(data);
		WriteResult wr = collection.update(new BasicDBObject("_id",
				new ObjectId(id)), candidateToUpdate);

		if (wr.getN() != 1) {
			throw new DBRequestException(
					"Candidate with this id doesn't exist.");
		}

	}

	public void removeCandidate(String id) {
		WriteResult wr = getCol().remove(
				new BasicDBObject("_id", new ObjectId(id)));
		if (wr.getN() != 1) {
			throw new DBRequestException(
					"Candidate with this id doesn't exist.");
		}

	}

	public void addEvaluation(String id) {
		DBObject db = getDBOID(id);
		Integer r = Integer.parseInt((String) db.get("rating"));
		r++;
		WriteResult wr = getCol().update(
				new BasicDBObject("_id", new ObjectId(id)),
				new BasicDBObject("$set", new BasicDBObject("rating", String
						.valueOf(r))));
		if (wr.getN() != 1) {
			throw new DBRequestException(
					"Candidate with this id doesn't exist.");
		}

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
			throw new DBServerException("Err connecting DB.");
		}
		return client.getDB("kand");
	}

	private DBCollection getCol() {
		return getDB().getCollection("candidates");
	}

	private Candidate getCandJSON(String data) {
		return getCanFromDBO(getDBO(data));
	}

	private DBObject getDBO(String data) {
		Object o = JSON.parse(data);
		DBObject db = null;
		if (o instanceof DBObject) {
			db = (DBObject) o;
		} else {
			throw new DBRequestException("JSON error.");
		}
		if (!checkCand(db)) {
			throw new DBRequestException("Wrong format of JSON.");
		}
		return db;
	}

	private Candidate getCanFromDBO(DBObject db) {
		return new Candidate(db.get("_id").toString(), (String) db.get("name"),
				(String) db.get("surname"), (String) db.get("age"),
				(String) db.get("height"), (String) db.get("weight"),
				(String) db.get("rating"));
	}

	private DBObject getDBOID(String id) {
		DBObject db = getCol().findOne(
				new BasicDBObject("_id", new ObjectId(id)));
		if(db==null) {
			throw new DBRequestException("DBObject with this id doesn't exist.");
		}
		return db;
	}

	private boolean checkCand(DBObject db) {
		if (db.get("name") == null) {
			return false;
		}
		if (db.get("surname") == null) {
			return false;
		}
		if (db.get("age") == null) {
			return false;
		}
		if (db.get("height") == null) {
			return false;
		}
		if (db.get("weight") == null) {
			return false;
		}
		if (db.get("rating") == null) {
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

	public Candidate getCandidateObj(String id) {
		return getCanFromDBO(getDBOID(id));
	}

	public List<Candidate> getCandidatesList() {
		List<Candidate> candidates = new ArrayList<Candidate>();
		DBCursor cursor = getCol().find();
		try {
			while (cursor.hasNext()) {
				DBObject cur = cursor.next();
				candidates.add(getCanFromDBO(cur));
			}
		} catch (Exception e) {
			throw new DBServerException("Err connecting DB.");
		} finally {
			cursor.close();
		}
		return candidates;
	}

	public List<Candidate> getCandidatesPage(int order) {
		List<Candidate> candidates = new ArrayList<Candidate>();
		DBCursor cursor = getCol().find().skip((order - 1) * PAGE_SIZE)
				.limit(PAGE_SIZE);

		try {
			while (cursor.hasNext()) {
				DBObject cur = cursor.next();
				candidates.add(getCanFromDBO(cur));
			}
		} catch (Exception e) {
			throw new DBServerException("Err connecting DB.");
		} finally {
			cursor.close();
		}
		return candidates;
	}

	public int getPagesCount() {
		Double pages = Math.ceil((double) getCol().getCount() / PAGE_SIZE);
		return pages.intValue();
	}

	public GridFSDBFile getImage(String id) {
		GridFS photos = new GridFS(getDB(), "photo");
		return photos.findOne(new BasicDBObject("filename", id));
	}
}
