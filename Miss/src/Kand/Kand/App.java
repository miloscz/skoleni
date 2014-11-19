package Kand.Kand;

import Kand.Kand.db.Candidate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	String[] a = new String[3];
         
    	Candidate c;
		try {
			c = new Candidate("", "David", "Stransky", "21", a, "44.4", "88.4", "0");
			System.out.println(c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
      
        
    	System.out.println( "Hello World!" );
    }
}


