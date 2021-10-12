package day2;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class Github {
	
  @Test(enabled=false)
  public void getallrepositories() {
	  given()
	  .auth()
	  .oauth2("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")
	 .when()
	 .get("https://api.github.com/user/repos")
	 .then()
	 .log()
	 .body()
	 .statusCode(200);
	 
  }
  @Test(enabled=true)
  public void createrepositories() {
	  JSONObject data =new JSONObject();
	  data.put("name","RestAssuredCreation");
	  data.put("description","I am the creator of RestAssured");
	  data.put("homepage","https://github.com/rajivrai");
	   
	  given()
	  .auth()
	  .oauth2("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")
	 .header("Content-Type","application/json")
	 .body(data.toJSONString())
	  .when()
	 .post("https://api.github.com/user/repos")
	 .then()
	 .log()
	 .body()
	 .statusCode(201)
	 .time(Matchers.lessThan(2000L), TimeUnit.MILLISECONDS);
  }
    
}
