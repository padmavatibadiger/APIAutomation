package org.api.test;

import java.util.HashMap;

import org.apache.http.entity.ContentType;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiTestCases {
	
	
	// Test case for login
	@Test(priority=1)
	 public void test_login()
	 {
		
		 Response res= RestAssured.given()
				 .header("Authorization", "Basic cVY3MzBibUdHbTJtM0I5UlJyeDYxVmJkS0x3YTpiVlZ4Qm5UZWg2WDF6aDFfdWZnX05lR0cxQzBh")
				  .header("Content-Type", "application/x-www-form-urlencoded")
				  .accept("application/json")
				  .urlEncodingEnabled(true)
				  .body("grant_type=password&username=0990463169&password=9971&scope=customers_add_non_recurring_beneficiary customers_delete_non_recurring_beneficiary customers_edit_non_recurring_beneficiary customers_get_beneficiary_by_id")
				  .when()
				   .post("https://apim-qa.nvizible.co.za/token")
				   .then()
				   .statusCode(200)
				   .assertThat()
				   .extract().response();
		 System.out.println(res.asString());
				  
	 }
	 
	//Test case for adding data
	
	 @Test(priority=2)
	 public void test_add()
	 {
		 Response res1 = RestAssured.given()
				 .header("Authorization", "Bearer 89dd160d-7229-3fc9-9044-43ffcbc2b36c")
				 .contentType("application/json")
				 .body("name=test&fromAccount=78600272872&accountTypeCode=1&accountNumber=78600272834&bankCode=BL00059&branchCode=683000&msisdn=0970181976&reference=reference&ownReference=reference&email=abc@gmail.com")
				 .when()
				   .post("https://apim-qa.nvizible.co.za/api/1.0.0/hbCustomers/customers/HG463169/beneficiaries")
				   .then()
				   .statusCode(200)
				   .extract().response();
				 System.out.println(res1.asString());
	 }
	 
	 // Test case for updating data
	 
	 @Test(priority=3)
	 public void test_put()
	 { 
		 Response res2=RestAssured.given()
				 .header("Authorization", "Bearer 1a451563-76a1-33a3-8f4e-7f5325057997")
				 .contentType("application/json")
				 .body("name=test1&accountTypeCode=3&accountNumber=78600272834&bankCode=BL00059&branchCode=683000&email=abcedit@gmail.com&reference=78600010173.sudhaka5&ownReference=78600010173.sudhaka5&msisdn=0970181976")
				 .when()
				 .put("https://apim-qa.nvizible.co.za/api/1.0.0/hbCustomers/customers/HG463169/beneficiaries/24760")
				 .then()
				 .statusCode(200)
				 .extract().response();
		 System.out.println(res2.asString());
			
		 
	 }
	 
	 //Test case for fetching data
	 
	 @Test(priority=4)
		public void test_get()
		{
			           RestAssured.given()
					     .header("Authorization", "Bearer fe6f82d7-6a8d-3ac2-966d-89ee246b0671")
			             .contentType("application/json")
			             .when()
			             .get("https://apim-qa.nvizible.co.za/api/1.0.0/hbCustomers/customers/HG463169/beneficiaries/24760?beneficiaryStatus=Active&beneficiaryType=NonRecurring")
			   
			             .then()
			             .statusCode(200);
			
		}
	 
	 //Test case for deleting data
	 
	 @Test(priority=5)
	 public void test_delete()
	 {
		 RestAssured.given()
		 .header("Authorization", "Bearer 1a451563-76a1-33a3-8f4e-7f5325057997")
		 .contentType("application/json")
		 .when()
		 .delete("https://apim-qa.nvizible.co.za/api/1.0.0/hbCustomers/customers/HG463169/beneficiaries")
		 .then()
		 .statusCode(204);
	 }
	 
	 
	 
}
