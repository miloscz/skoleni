package login;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Component;

@Component
public class SimpleLogin {
	String username;
	String password;
	List<User> list;
	
	public SimpleLogin(){
		list = new ArrayList<User>();
		User user = new User("user", passToBase64("password"));
		User admin = new User("admin", passToBase64("admin"));
		User user2 = new User("halkeey", passToBase64("halkeey123"));
		list.add(user);
		list.add(admin);
		list.add(user2);
	}
	
	public boolean simpleLogin(String username, String password){
		this.username = username;
		this.password = password;
		System.out.println("Simple Login");
		if(username==null || password==null){
			return false;
		}else {
			return checkAuth();
		}	
	}
	
	public String passToBase64(String password){
		String str = null;
		try {
		Base64 b64 = new Base64();
		byte[] hash = b64.decode(password);
			str = new String(hash, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			System.out.println("Error: method: passToBase64()");
		}
		System.out.println("passToBase64");
		return str;
	}

	private boolean checkAuth(){
		
		for(User users:list){
			User user = users;
			if((user.getPassword().equals(passToBase64(password))) && (user.getUsername().equals(username))){
				System.out.println("checkAuth() = true");
				return true;
			}	
		}
		System.out.println("checkAuth() = false");
		return false;
	}
}
