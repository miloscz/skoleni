package org.entities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import sun.rmi.runtime.Log;


public class TestCreateCandidates {

	static String str =new String( "[{\"firstName\":\"andrea\", \"surname\":\"novotna\", \"age\":\"46\""
			+ ", \"heigth\":\"146\", \"weight\":\"50\", \"votes\":\"0\","
			+ " \"chest\":\"200\", \"waist\":\"20\", \"hips\":\"100\"}, "
			+ "{\"firstName\":\"michal\", \"surname\":\"novak\", \"age\":\"50\""
			+ ", \"heigth\":\"170\", \"weight\":\"70\", \"votes\":\"7\","
			+ " \"chest\":\"120\", \"waist\":\"30\", \"hips\":\"70\"}]}");
	
	static String str1 =new String("{\"firstName\":\"andrea\", \"surname\":\"novotna\", \"age\":\"46\""
			+ ", \"heigth\":\"146\", \"weight\":\"50\",\"weight\":\"50\", \"votes\":\"0\","
			+ " \"heigth\":\"200\", \"waist\":\"20\", \"hips\":\"100\"}");
	


	public static void main(String[] args){
		ArrayList<Candidate> cands;
		cands=(ArrayList<Candidate>)CandidateFactory.createList(str);
		
		//Candidate can= CandidateFactory.createCandidate(str1);
		//System.out.println(can.getAge());
		
		for (Candidate candidate : cands) {
			System.out.println(candidate.getFirstName());
		}
		
//		try {
//			System.out.println("-----------------------");
//			System.out.println(readFile("C:\\Users\\User\\git\\skoleni\\src\\resources\\missdb.txt"));
//			System.out.println("-----------------------");
//		} catch (IOException e) {
//			System.out.println("Wrong path or something");
//			e.printStackTrace();
//		}
	}
	
	private static String readFile(String path) throws IOException{
		BufferedReader reader = new BufferedReader(new FileReader(path));
		String line = null, neco;
		StringBuilder sb = new StringBuilder();
		System.out.println(line = reader.readLine());
		
		for ( line = reader.readLine(); line != null; line = reader.readLine()) {
			sb.append(line);
		}
		
		System.out.println(sb.toString());
		return sb.toString();
	}

}
