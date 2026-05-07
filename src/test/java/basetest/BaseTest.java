package basetest;

import org.testng.annotations.BeforeMethod;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import utils.ConfigReader;
import utils.TokenManager;

public class BaseTest {
	public static RequestSpecification request;
	@BeforeMethod
	
	public void setUp() {
		 request=RestAssured.given()
				 .baseUri(ConfigReader.get("baseUrl"))
				.header("Authorization", "Bearer " + TokenManager.getToken())
				.header("Content-Type", "application/json");
				
		
		
	}

}
