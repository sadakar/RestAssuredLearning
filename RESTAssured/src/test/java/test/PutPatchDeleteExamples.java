package test;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class PutPatchDeleteExamples {

	@Test
	public void testPut() {

		JSONObject request = new JSONObject();
		request.put("name", "Sadakar2");
		request.put("job", "Software Engineer2");
		System.out.println(request.toJSONString());
		
		baseURI = "https://reqres.in/api";
		
		given().body(request.toJSONString()).when().put("/users/2").then().statusCode(200).log().all();
	}
	@Test
	public void testPatch() {

		JSONObject request = new JSONObject();
		request.put("name", "Sadakar2");
		request.put("job", "Software Engineer2");
		System.out.println(request.toJSONString());
		
		baseURI = "https://reqres.in";
		
		given().body(request.toJSONString()).when().patch("/api/users/2").then().statusCode(200).log().all();
	}
	@Test
	public void testDelete() {

				
		baseURI = "https://reqres.in";
		
		when().delete("/api/users/2").then().statusCode(204).log().all();
	}
}
