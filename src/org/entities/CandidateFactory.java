package org.entities;


import java.util.ArrayList;
import java.util.List;

public class CandidateFactory {

	public static Candidate createCandidate(String firstName, String surname, 
			int age, double chest, double waist, double hips,  double heigth, double weight,
			int votes) {
		
		return new Candidate(firstName, surname, age, chest, waist, hips, heigth, weight,votes);
	}
	
	public List<Candidate> parse(String json){
		
		
		return new ArrayList<>();
	}
	
}
