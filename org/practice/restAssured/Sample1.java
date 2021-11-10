package org.practice.restAssured;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Sample1 {

	public static void main(String[] args) {
		RestAssured.baseURI="https://jirapracticeandrews.atlassian.net/";
		Response response = RestAssured.
				given()
				.header("Content-Type","application/json")
				.auth()
				.preemptive()
				.basic("andrewspravinsha2699@gmail.com","WjQUn3RsmLyIaKtpjmSc46F9")
				.when()
				.get("/rest/api/2/search");
		System.out.println(response.getStatusCode());
		String prettyString = response.getBody().asPrettyString();
		System.out.println(prettyString);


	}

}
