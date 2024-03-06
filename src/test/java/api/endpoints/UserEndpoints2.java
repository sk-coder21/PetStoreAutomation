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

import java.util.ResourceBundle;


//userEndpoints.java
//created for perform CRUD operation

public class UserEndpoints2 {
	//method created for getting URL'S FROM properties file
	
	static ResourceBundle getURL()
	{
		ResourceBundle routes=ResourceBundle.getBundle("routes");//load properties file
		return routes;
	}
	
	public static Response createUser(User payload)
	{
	String	Post_url=getURL().getString("post_url");
		
		Response response=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		
	  .when()
	      .post(Post_url);
		  
		return response;
	}
	
	public static Response readUser(String userName)
	
	{
		String	Get_url=getURL().getString("get_url");
		Response response=given()
		                  .pathParam("username", userName)
	
		
		
	  .when()
	      .get(Get_url);
		  
		return response;
	}
	
	public static Response updateUser(String UserName,User payload)
	{
		String	update_url=getURL().getString("update_url");
		
		Response response=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.pathParam("username", UserName)
		.body(payload)
		
	  .when()
	      .put(update_url);
		  
		return response;
	}
	
	public static Response deleteUser(String userName)
	{
		String	delete_url=getURL().getString("delete_url");
		
		Response response=given()
		                  .pathParam("username", userName)
	
		
		
	  .when()
	      .delete(delete_url);
		  
		return response;
	}
}
