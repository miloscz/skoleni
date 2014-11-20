package testing;

import java.net.UnknownHostException;

import backend.DBHandler;

public class MissTest {

	public static void main(String[] args) throws Exception   {
		DBHandler handler = DBHandler.getInstance();
		String body = "{ \"firstName\": \"Andrea\", \"surname\": \"Novotna\", \"age\": \"19\", \"height\": \"150\", \"weight\": \"50\", \"votes\": \"0\", \"parameters\":{ \"chest\": \"200\", \"waist\": \"20\", \"hips\": \"100\" }";
		String candidate = handler.createCandidate(body);
		System.out.println(candidate);

	}

}
