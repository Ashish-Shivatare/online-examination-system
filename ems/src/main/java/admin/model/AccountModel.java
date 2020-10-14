package admin.model;

public class AccountModel {
	public boolean login(String username, String password) {
		return username.equalsIgnoreCase("abc") && password.equalsIgnoreCase("123");
	}
	
	public boolean studentLogin(String username, String password) {
		return username.equalsIgnoreCase("xyz") && password.equalsIgnoreCase("789");
	}
}
