package org.test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import pojovalidation.SingleUserData;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;
import static io.restassured.RestAssured.*;

public class ValidateResponseBody {

	// Reqres
	// URL --> https://reqres.in/api/users/2

	public static void main(String[] args) {

		RestAssured.baseURI = "https://reqres.in/api/users/2";
		Response response = given().header("x-api-key", "reqres-free-v1").when().get();
		SingleUserData as = response.as(SingleUserData.class);
		// Getting Response body by using JsonPath()
		String id = response.jsonPath().get("data.id").toString();
		System.out.println(id);

	}

}
