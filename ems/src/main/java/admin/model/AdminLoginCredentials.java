package admin.model;

public class AdminLoginCredentials {
	public boolean login(String username, String password) {
		return username.equalsIgnoreCase("abc") && password.equalsIgnoreCase("123");
	}
}
