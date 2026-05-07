package utils;

public class TokenManager {
	private static String token;

    public static synchronized String getToken() {

        if (token == null) {
            token = ConfigReader.get("token");
        }
        return token;
    }

}
