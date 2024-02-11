package test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class GetAndPostExamples {

	// @Test
	public void testGet() {
		baseURI = "https://reqres.in/api";

		given().get("/users?page=2").then().statusCode(200).body("data[4].first_name", equalTo("George"))
				.body("data.first_name", hasItems("George", "Rachel"));
	}

	@Test
	public void testPost() {
		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("name", "Sadakar");
//		map.put("job", "Software Engineer");
//		System.out.println(map);
//		
		// JSONObject request = new JSONObject(map);

		JSONObject request = new JSONObject();
		request.put("name", "Sadakar2");
		request.put("job", "Software Engineer2");
		System.out.println(request.toJSONString());
		
		baseURI = "https://reqres.in/api";
		
		given().body(request.toJSONString()).when().post("/users/2").then().statusCode(201).log().all();
	}
}
