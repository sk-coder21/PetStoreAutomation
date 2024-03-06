package api.endpoints;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import api.payloads.User;
import io.restassured.response.Response;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


//userEndpoints.java
//created for perform CRUD operation

public class UserEndpoints {
	
	public static Response createUser(User payload)
	{
		Response response=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		
	  .when()
	      .post(Routes.post_url);
		  
		return response;
	}
	
	public static Response readUser(String userName)
	{
		Response response=given()
		                  .pathParam("username", userName)
	
		
		
	  .when()
	      .get(Routes.get_url);
		  
		return response;
	}
	
	public static Response updateUser(String UserName,User payload)
	{
		Response response=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.pathParam("username", UserName)
		.body(payload)
		
	  .when()
	      .put(Routes.update_url);
		  
		return response;
	}
	
	public static Response deleteUser(String userName)
	{
		Response response=given()
		                  .pathParam("username", userName)
	
		
		
	  .when()
	      .delete(Routes.delete_url);
		  
		return response;
	}
}
