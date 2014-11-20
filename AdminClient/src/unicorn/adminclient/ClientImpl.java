package unicorn.adminclient;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.sun.jersey.core.util.Base64;

public class ClientImpl {

	private static final String filePath = "import.json";

	public static void main(String[] args) {	

		Reader reader = null;
		OutputStreamWriter outPutStreamWriter = null;
		
		InputStreamReader streamReader=new InputStreamReader(System.in);
		BufferedReader br = null;        
		
		try {	
			System.out.print("Vlozte cestu k souboru.");
					
			br = new BufferedReader(streamReader);
			String filepath = br.readLine();	
			reader = new FileReader(filePath);

			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject;
			JSONArray candidates = null;
			try {
				jsonObject = (JSONObject) jsonParser.parse(reader);
				candidates = (JSONArray) jsonObject.get("candidates");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}			

			String urlPath = "http://localhost:8080/mongo/api/candidate/create";
			
			for (Object object : candidates) {

				try {
					URL url = new URL(urlPath);
					String credentials = "user:pass";
					URLConnection connection = url.openConnection();
					connection.setDoOutput(true);
					connection.setRequestProperty("Content-Type",
							"application/json");
					connection.setRequestProperty("charset", "UTF-8");
					byte[] encoded = Base64.encode(credentials);

					String encodedString = new String(encoded);
					connection.setRequestProperty("Authorization", "Basic "
							+ encodedString);

					connection.setConnectTimeout(5000);
					connection.setReadTimeout(5000);
					
					outPutStreamWriter = new OutputStreamWriter(
							connection.getOutputStream());
					outPutStreamWriter.write(object.toString());
					outPutStreamWriter.close();

					InputStream response = connection.getInputStream();
					Map<String, List<String>> map = connection.getHeaderFields();

					for (Map.Entry<String, List<String>> entry : map.entrySet()) {

						if (entry.getKey() == null) {
							String status = entry.getValue().toString();
							String statusOk = "[HTTP/1.1 200 OK]";

							if (statusOk.equalsIgnoreCase(status)) {
								System.out.println("Uspesne zapsano do databáze.");
							} else {
								System.out.println("Chyba pri ukladani pres REST.");
							}
						}

					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					//System.out.println("Spatny format JSON");
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		finally{
			
			try {
				if(reader!=null){
					reader.close();
				}
				if(outPutStreamWriter!=null){
					outPutStreamWriter.close();
				}
				if(br!=null){
					br.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println(e.getMessage());
			}			
		}
	}
}
