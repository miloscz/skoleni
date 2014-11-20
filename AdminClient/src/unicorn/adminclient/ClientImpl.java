package unicorn.adminclient;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
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

public class ClientImpl {

	
	private static final String filePath = "import.json";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Reader reader = null;
		OutputStreamWriter outPutStreamWriter = null;
		try {
			reader = new FileReader(filePath);
			
			
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
			
			JSONArray candidates = (JSONArray) jsonObject.get("candidates");
			
			String urlPath = "http://localhost:8080/mongo/api/candidate/create";
			URL url = new URL(urlPath);
			for (Object object : candidates) {
				
			
				URLConnection connection = url.openConnection();
				connection.setDoOutput(true);
				connection.setRequestProperty("Content-Type", "application/json");
				
                connection.setConnectTimeout(5000);
                connection.setReadTimeout(5000);
                outPutStreamWriter = new OutputStreamWriter(connection.getOutputStream());
                outPutStreamWriter.write(object.toString());
                outPutStreamWriter.close();					
                
                InputStream response = connection.getInputStream();
                // String body = IOUtils.toString(response);
                Map<String, List<String>> map = connection.getHeaderFields();
                
            	
             
            	for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            		System.out.println("Key : " + entry.getKey() 
                                       + " ,Value : " + entry.getValue());
            	}
             
            	System.out.println("\nGet Response Header By Key ...\n");
            	String server = connection.getHeaderField("Server");
              
                
                
                
              
			}

			
		} catch(FileNotFoundException e){
			e.printStackTrace();
		}		
		catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

	}

}
