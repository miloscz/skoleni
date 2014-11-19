package org.entities;

public class CandidateFactory {

	public static Candidate createCandidate(String firstName, String surname, 
			int age, double chest, double waist, double hips) {
		
		return new Candidate(firstName, surname, age, chest, waist, hips);
	}
	
	
}
