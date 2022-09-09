package apiEngine.model.common;

import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Endpoints {
	//private static final String BASE_URL = "https://api.dev-rusen.in/userservice/extUserService";
	CreateJSONObject json =  new CreateJSONObject();
	private final RequestSpecification request;

	public Endpoints(String baseUrl) {
	        RestAssured.baseURI = baseUrl;
	        request = RestAssured.given();
	        request.header("Content-Type", "application/json").header("productConfigId","28cb0ebc-ee8a-4180-865b-7815c1ceaba7");
	    }

	
	public Response getResponse(Map<String, String> data ,String Route) {
		Response response = request.body(json.objectCreation(data)).post(Route);
		
	
		return response;
	}
	
	
	

}
