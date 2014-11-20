package org.entities;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;




public class CandidateFactory {

	public static Candidate createCandidate(String candidate) {
		Candidate m =JSON.fromJson(candidate,Candidate.class);
				
		return m;
	}
	
	
	// NESTIHL JSEM ODZKOUSET, SPIS ALE NEFUNGUJE
	public static List<Candidate> createList(String json){
		ArrayList<Candidate> candidates = new ArrayList<Candidate>();
		
		//JSONObject obj = new JSONObject(json);

		//candidates =JSON.fromJson(json,ArrayList.class);
		candidates = (ArrayList<Candidate>) JSON.fromJsonList(json);

//		for (int i = 0; i < candidates.size(); i++)
//		{
//			candidates.add(createCandidate(candidates.get(i).toString()));   	   
//		}
		
		return candidates;
	}
	
	
}
