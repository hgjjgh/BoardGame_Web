package BoardGame.entity;

public class User {
	private int id;
	private String userName,password,name;

	public User(int id,String userName, String password, String name) {
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.id=id;
	}


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int id() {
		return id;
	}

	public void setid(int id) {
		this.id = id;
	}


    
	
	

}
