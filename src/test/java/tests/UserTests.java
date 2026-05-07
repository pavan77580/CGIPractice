package tests;

import org.testng.annotations.Test;

import basetest.BaseTest;
import endpoints.Routes;
import io.restassured.response.Response;
import payload.UserPayLoad;

public class UserTests extends BaseTest{
	
	int userId;
	
	
	@Test(priority=1)
	
	public void createUser() {
		UserPayLoad user=new UserPayLoad();
		user.setName("pavan");
		user.setEmail("pavan" +System.currentTimeMillis()+ "gmail.com");
		user.setGender("male");
		user.setStatus("active");
		
		Response rs= request.body(user)
				.when()
		
		.post(Routes.createUser);
		rs.then().statusCode(201);
		userId =rs.jsonPath().getInt("id");
		
		System.out.println("Create User Response: " + rs.asString());

	}
	
	
	@Test(priority=2)
	
	public void getUser() {
		
		
		request.pathParam("id", userId)
		.when()
		.get(Routes.getUser)
		.then()
		.statusCode(200);
	}
	
	@Test(priority=3)
	
	public void UpdateUser() {
		
		UserPayLoad user=new UserPayLoad();
		user.setName("Update Pavan");
		user.setStatus("inactive");
		
		
		Response rs=request.pathParam("id", userId)
		.when()
		.put(Routes.updateUser);
		rs.then()
		.statusCode(200);
		rs.prettyPrint();
		
		
		
		
		
		
		
	}

}
