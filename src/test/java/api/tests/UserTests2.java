package api.tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndpoints;
import api.endpoints.UserEndpoints2;
import api.payloads.User;
import io.restassured.response.Response;

public class UserTests2 {
	
	Faker faker;
	User userPayload;
	public Logger logger;
	@BeforeClass
	public void setupData() {
		faker=new Faker();
		userPayload=new User();

		
		userPayload.setId(faker.idNumber().hashCode());
	
	    userPayload.setUsername(faker.name().username());
	    
	    userPayload.setFirstname(faker.name().firstName());
	    
	    userPayload.setLastname(faker.name().lastName());
	    
	    userPayload.setEmail(faker.internet().safeEmailAddress());
	    
	    userPayload.setPassword(faker.internet().password(5,10));
	    
	    userPayload.setPhone(faker.phoneNumber().cellPhone());
	    
	   //logs
	    logger=LogManager.getLogger(this.getClass());
	}
	
	
	@Test(priority=1)
	public void testPostUser(){
		
		logger.info("      creatings user    ");
		 Response response=UserEndpoints2.createUser(userPayload);
		 response.then().log().all();
		 Assert.assertEquals(response.getStatusCode(),200);
		 logger.info("      user created    ");
	}
	
	@Test(priority=2)
	public void testGetUserbyName() {
		logger.info("      reading user info    ");
		Response response=UserEndpoints2.readUser(this.userPayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
		logger.info("      user info displayed    ");
	}
	
	@Test(priority=3)
	public void testupdateUserbyname(){
		logger.info("      updaing user info    ");
		
		//update data using payload
        userPayload.setFirstname(faker.name().firstName());
	    
	    userPayload.setLastname(faker.name().lastName());
	    
	    userPayload.setEmail(faker.internet().safeEmailAddress());
		
		 Response response=UserEndpoints2.updateUser(this.userPayload.getUsername(),userPayload);
		// response.then().log().all();
		 AssertJUnit.assertEquals(response.getStatusCode(),200);
		 response.then().log().body().statusCode(200);
		 
		//checking data after update:
		 Response responseAfterUpdate=UserEndpoints2.readUser(this.userPayload.getUsername());

		Assert.assertEquals(responseAfterUpdate.getStatusCode(),200);
		 
	}
	@Test(priority=4)
	public void testDeleteUserbyName() {
		Response response=UserEndpoints2.deleteUser(this.userPayload.getUsername());
		AssertJUnit.assertEquals(response.getStatusCode(),200);
		
	}
	
	
}
