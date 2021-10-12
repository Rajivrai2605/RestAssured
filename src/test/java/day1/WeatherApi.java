package day1;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class WeatherApi {
  @Test(description="getting weather info of specific city")
  public void getWeather() {
	  RestAssured.given()	//pre condition authentication
	  			.when()		//perform some steps
	  			.get("https://api.openweathermap.org/data/2.5/weather?q=Ghazipur&appid=b7bbe6eac2d08dea491ce4e087c69515")
	  			.then()		// post condition like verification
	  			.log()  //print data in console
	  			.body()
	  			.statusCode(200);	  			
	  System.out.println("=============================================================");
  }
 
  @Test(description="getting weather info of specific city")
  public void getWeather1() {
	 Response res = RestAssured.given()	//pre condition authentication
	  			.queryParam("q","Mumbai")
	  			.queryParam("appid","b7bbe6eac2d08dea491ce4e087c69515")
			 .when()		//perform some steps
	  			.get("https://api.openweathermap.org/data/2.5/weather");
	  			
	  	System.out.println(res.prettyPrint());
	 	System.out.println(res.getTime());
	 	System.out.println(res.getStatusCode());
	 	System.out.println(res.getContentType());
	 	
	 	
}
}
