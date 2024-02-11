package test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
public class TestsOnLocalAPI {

	//@Test
	public void get() {
		
		baseURI ="http://localhost:3000";
	given().get("/users").then().statusCode(200).log().all();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void post() {
		JSONObject request = new JSONObject();
		request.put("firstName", "Thomas");
		request.put("lastNameName", "Edison");
		request.put("subjectId", 1);
		
		baseURI = "http://localhost:3000";
		given().contentType(ContentType.JSON).accept(ContentType.JSON).body(request.toJSONString()).when().post("/users").then().statusCode(201);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void put() {
		JSONObject request = new JSONObject();
		request.put("firstName", "Albert");
		request.put("lastNameName", "Einstein");
		request.put("subjectId", 2);
		
		baseURI = "http://localhost:3000";
		given().contentType(ContentType.JSON).accept(ContentType.JSON).body(request.toJSONString()).when().put("/users/67c4").then().statusCode(200);
	}
	@SuppressWarnings("unchecked")
	@Test
	public void patch() {
		JSONObject request = new JSONObject();
		request.put("lastNameName", "Doe");
		
		baseURI = "http://localhost:3000";
		given().contentType(ContentType.JSON).accept(ContentType.JSON).body(request.toJSONString()).when().patch("/users/67c4").then().statusCode(200);
	}
	
	@Test
	public void delete() {
		baseURI = "http://localhost:3000";
		when().delete("/users/67c4").then().statusCode(200);
	}
}
