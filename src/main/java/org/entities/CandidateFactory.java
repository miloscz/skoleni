package org.entities;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class CandidateFactory {

	public static Candidate createCandidate(DBObject item) throws RuntimeException {

		Candidate c = new Candidate();
		try {
			c.setAge(((Double) item.get("age")).intValue());
			c.setId(item.get("_id").toString());
			c.setFirstName(item.get("firstName").toString());
			c.setSurname(item.get("surname").toString());
			c.setHeigth(((Double) item.get("height")).intValue());
			c.setWeight(((Double) item.get("weight")).intValue());
			c.setVotes(((Double) item.get("votes")).intValue());
			c.setChest(((Double) item.get("chest")).intValue());
			c.setWaist(((Double) item.get("waist")).intValue());
			c.setHips(((Double) item.get("hips")).intValue());
			return c;
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		// Candidate m =JSON.fromJson(candidate,Candidate.class);

		return null;
	}

	// NESTIHL JSEM ODZKOUSET, SPIS ALE NEFUNGUJE
	public static List<Candidate> createList(DBCursor cur) {

		ArrayList<Candidate> candidates = new ArrayList<Candidate>();
		Candidate can;
		while (cur.hasNext()) {

			DBObject item = cur.next();
			can = createCandidate(item);
			if (can != null) {
				candidates.add(can);
			}

		}

		// JSONObject obj = new JSONObject(json);

		// candidates =JSON.fromJson(json,ArrayList.class);
		// candidates = (ArrayList<Candidate>) JSON.fromJsonList(json);

		// for (int i = 0; i < candidates.size(); i++)
		// {
		// candidates.add(createCandidate(candidates.get(i).toString()));
		// }

		return candidates;
	}

}
