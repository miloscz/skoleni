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
        Candidate c = new Candidate();
        c.setAge(10);
        c.setName("david");
        c.setSurname("stransky");
        c.getRating().add(0);
        c.getRating().add(8);
        System.out.println(c);
        
    	System.out.println( "Hello World!" );
    }
}


