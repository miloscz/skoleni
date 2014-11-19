package Kand.Kand;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;

import Kand.Kand.db.DBConnect;
import Kand.Kand.db.DbUtil;

public class RestApiTest {

	public static void main(String[] args) {
		RestApiTest.testCandidates();

	}
	
	private static void testCandidates(){
		
		DbUtil db = DBConnect.getInstance();
		try {
			/**
			 * Vypis kandidatu
			 */
			System.out.println(db.getCandidates());			
			
			
			DBObject  object = new BasicDBObject("name","David")
							.append("surname", "Stransky")
							.append("age", 39)
							.append("height",55.5)
							.append("weight",77.9);
			
			String data = JSON.serialize(object);				
			object = (DBObject) JSON.parse(data);				
			db.addCandidate(data);
			
			//String lastId =  object.get("_id").toString();			
			DBObject object2 =  new BasicDBObject("name","Petr")
			.append("surname", "Parler")
			.append("age", 70)
			.append("height",54.5)
			.append("weight",73.9);
			
			String lastId = "546cb211d6ca1a20caad9aef";
			System.out.println("Edituju kandidata id: "+lastId);
			db.editCandidate(lastId, JSON.serialize(object2));
			
			db.removeCandidate("546cb211d6ca1a20caad9aef");
			
			
			String id = "";
			System.out.println("=====Testovani kandidate id"+id);
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
