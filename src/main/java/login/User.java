package login;

public class User {
	
	private String username;
	private Object password;

	public User(String username, String password){
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Object getPassword() {
		return password;
	}

	public void setPassword(Object password) {
		this.password = password;
	}
	

}
