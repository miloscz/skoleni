package org.entities;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class CandidateFactory {


	private static Integer convert(Double doub){
		return  doub.intValue();
		
	}
	
	private static int convert(Object o){
		if (o instanceof Double){return convert((Double)o);}
		return (Integer) o;
	}
	
	
	
	public static Candidate createCandidate(DBObject item) throws RuntimeException {

		Candidate c = new Candidate();
	//	try {
			
			c.setAge(convert((item.get("age"))));
			c.setId(item.get("_id").toString());
			c.setFirstName(item.get("firstName").toString());
			c.setSurname(item.get("surname").toString());
			c.setHeight(convert (  item.get("height"))  );
			c.setWeight(convert( item.get("weight")));
			c.setVotes(convert(item.get("votes")));
			c.setChest(convert( item.get("chest")));
			c.setWaist(convert( item.get("waist")));
			c.setHips(convert( item.get("hips")));
			return c;
	//	} catch (Exception ex) {
		//	ex.printStackTrace();
		//}

	//	 Candidate m =JSON.fromJson(candidate,Candidate.class);

		//return null;
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
	
	public static Candidate createCandidate(String json) {
		

		return JSON.fromJson(json,Candidate.class);
	}

}
