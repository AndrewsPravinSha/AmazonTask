package org.practical.restAssured;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Sample2 {

	public static void main(String[] args) {
		RestAssured.baseURI ="https://reqres.in/";

		Response getResponse = RestAssured
				.given()
				.header("Content-Type","application/json")
				.when()
				.get("https://reqres.in/api/users/2");
		
		int statusCode = getResponse.statusCode();
		String statusLine = getResponse.statusLine();
		System.out.println(statusCode + statusLine);
		
		String jsonBody = getResponse.getBody().asPrettyString();
		System.out.println(jsonBody);

	}

}
