package day2;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
public class NegativeContactList {
  @Test
  
  public void recordnotfound() {
	  given()
	  .when()
	  .get("http://3.13.86.142:3000/contacts/5")
	  .then()
	  .log()
	  .body()
	  .statusCode(404);	  	
  }
  @Test(enabled=true,description="Adding Contact with missing detail ")
  public void addingContactmissing() {
  JSONObject details=new JSONObject();
  JSONObject loc=new JSONObject();
  JSONObject emp=new JSONObject();
  
  loc.put("city", "Mumbai");
  loc.put("country", "India");
  emp.put("JobTitle", "Don");
  emp.put("company", "LTI");
  details.put("firstName", "Rajiv");
  details.put("lastName","");
  details.put("email", "12ka4@gmail.com");
  details.put("location", loc);
  details.put("employer", emp);
  
  	String error=	given()
	 .header("Content-Type","application/json")
	 .body(details.toJSONString())
	 .when()
	 .post("http://3.13.86.142:3000/contacts")
	 .then()
	 .log()
	 .body()
	 .statusCode(400)
	 .extract()
	 .path("err");
	Assert.assertTrue(error.contains("lastName: Last Name is required"));
  }
  @Test(enabled=true,description="Adding Contact with many character ")
  public void addingtoomanycharacters() {
  JSONObject details=new JSONObject();
  JSONObject loc=new JSONObject();
  JSONObject emp=new JSONObject();
  
  loc.put("city", "MumbaiMumbaiMumbaiMumbaiMumbaiMumbaiMumbaiMumbai");
  loc.put("country", "India");
  emp.put("JobTitle", "Don");
  emp.put("company", "LTI");
  details.put("firstName", "Rajiv");
  details.put("lastName","");
  details.put("email", "12ka4@gmail.com");
  details.put("location", loc);
  details.put("employer", emp);
  
  	String error=	given()
	 .header("Content-Type","application/json")
	 .body(details.toJSONString())
	 .when()
	 .post("http://3.13.86.142:3000/contacts")
	 .then()
	 .log()
	 .body()
	 .statusCode(400)
	 .extract()
	 .path("err");
	Assert.assertTrue(error.contains("is longer than the maximum allowed length"));
  
  }
  @Test(enabled=true,description="Invalid Character")
  public void invalidcharacter() {
  JSONObject details=new JSONObject();
  JSONObject loc=new JSONObject();
  JSONObject emp=new JSONObject();
  
  loc.put("city", "Mumbai");
  loc.put("country", "India");
  emp.put("JobTitle", "Don");
  emp.put("company", "LTI");
  details.put("firstName", "1Raj");
  details.put("lastName","2Raj");
  details.put("email", "12ka4@gmail.com");
  details.put("location", loc);
  details.put("employer", emp);
  
  	String error=	given()
	 .header("Content-Type","application/json")
	 .body(details.toJSONString())
	 .when()
	 .post("http://3.13.86.142:3000/contacts")
	 .then()
	 .log()
	 .body()
	 .statusCode(400)
	 .extract()
	 .path("err");
	Assert.assertTrue(error.contains("Validator failed for path")); 
  }
  @Test(enabled=true,description="Missing Parameter")
  public void missingparameter() {
  JSONObject details=new JSONObject();
  JSONObject loc=new JSONObject();
  JSONObject emp=new JSONObject();
  
  loc.put("city", "Mumbai");
  loc.put("country", "India");
  emp.put("JobTitle", "Don");
  emp.put("company", "LTI");
  details.put("firstName", "1Raj");
  details.put("lastName","2Raj");
  details.put("email", "12ka4gmail.com");
  details.put("location", loc);
  details.put("employer", emp);
  
  	String error=	given()
	 .header("Content-Type","application/json")
	 .body(details.toJSONString())
	 .when()
	 .post("http://3.13.86.142:3000/contacts")
	 .then()
	 .log()
	 .body()
	 .statusCode(400)
	 .extract()
	 .path("err");
	Assert.assertTrue(error.contains("Validator failed for path")); 
  }
  
  
}
