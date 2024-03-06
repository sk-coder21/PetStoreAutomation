package api.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;
import api.payloads.User;
import api.endpoints.UserEndpoints;

import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DDTests {

	@Test(priority=1,dataProvider="Data",dataProviderClass=DataProviders.class)
	public void testPostUser(String UserId,String UserName,String FirstName,String LastName,String Email,String Password,String ph){
		
	User userPayload=new User();
		
		userPayload.setId(Integer.parseInt(UserId));
	
	    userPayload.setUsername(UserName);
	    
	    userPayload.setFirstname(FirstName);
	    
	    userPayload.setLastname(LastName);
	    
	    userPayload.setEmail(Email);
	    
	    userPayload.setPassword(Password);
	    
	    userPayload.setPhone(ph);
	    
		 Response response=UserEndpoints.createUser(userPayload);
		
		 AssertJUnit.assertEquals(response.getStatusCode(),200);
	}
	
	
	@Test(priority=2,dataProvider="UserNames",dataProviderClass=DataProviders.class)
	public void testDeleteUserbyName(String UserName) {
		 Response response=UserEndpoints.deleteUser(UserName);
			
		 AssertJUnit.assertEquals(response.getStatusCode(),200);	
}
}

