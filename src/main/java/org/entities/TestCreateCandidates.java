package org.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.List;

import backend.DBHandler;


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
	


	

}
