package org.test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class SampleAPICLass {

	public static String accessToken = "bc946e20145e59169e1fc5fb7ae32a2977f6db4e7a6d528aa4117ae005c68ff8";
	public static String orderId = "x0Fy9NuQc9hNPGsU05SRE";

	public static void generateBearerToken() {
		RestAssured.baseURI = "https://simple-books-api.glitch.me/api-clients";
		// HashMap --> used to pass test data

		HashMap map = new HashMap();
		// adding value to map
		map.put("clientName", "Saba");
		map.put("clientEmail", "sabasiva06@gmail.com");

		Response post = given().body(map).contentType(ContentType.JSON).when().post();
		System.out.println(post.getStatusCode());
		System.out.println(post.getBody().asPrettyString());

	}

	public static void orderBookInSampleBookAPI() {
		RestAssured.baseURI = "https://simple-books-api.glitch.me/orders";
		// post
		HashMap map = new HashMap();
		map.put("bookId", 1);
		map.put("customerName", "Suresh");

		Response post = given().body(map).contentType(ContentType.JSON).header("Authorization", "Bearer " + accessToken)
				.when().post();

		System.out.println(post.getStatusCode());
		System.out.println(post.getBody().asPrettyString());
	}

	public static void getOrderDetails() {

		RestAssured.baseURI = "https://simple-books-api.glitch.me/orders/" + orderId;

		Response post = given().header("Authorization", "Bearer " + accessToken).when().get();
		System.out.println(post.getStatusCode());
		System.out.println(post.getBody().asPrettyString());
	}

	public static String passingOfAPIKey() {
		RestAssured.baseURI = "https://api.openweathermap.org/data/2.5/weather";

		Response response = given().queryParam("lat", "44.34").queryParam("lon", "10.99")
				.queryParam("appid", "8a978bd9ee26aac8eeb40a80beafc2d4").when().get();

		System.out.println(response.getStatusCode());
		ResponseBody body = response.getBody();
		
		System.out.println(body.asPrettyString());
		String string = body.jsonPath().get("coord.lon").toString();
		String Weather_id = body.jsonPath().get("weather[0].id").toString();
		System.out.println("Weather :" + Weather_id);
        String base = body.jsonPath().get("base").toString();
		System.out.println("Base :"+ base);
		
		String temp_minn = body.jsonPath().get("main.temp_min").toString();
		System.out.println("Temperature detais :"+ temp_minn);
		
		String visibility = body.jsonPath().get("visibility").toString();
		System.out.println("Visibility :"+visibility);
		
		String wind_speed = body.jsonPath().get("wind.speed").toString();
		System.out.println("Wind_speed :"+wind_speed);
		
		String all = body.jsonPath().get("clouds.all").toString();
		System.out.println("Clouds :"+all);
		
		String sun = body.jsonPath().get("sys.sunrise").toString();
		System.out.println("sunrise :"+sun);
		
		
		
		
		
		
        
        
		return string;

	}

	public static void main(String[] args) {
		// How to pass Authorization in Rest Assured.
		// 1.Basis Auth
		/*
		 * RestAssured.baseURI = "https://postman-echo.com/basic-auth"; Response
		 * response = given().auth().basic("postman", "password").when().get(); //
		 * Response code & Response body String a = response.getBody().asPrettyString();
		 * System.out.println(a);
		 * 
		 * // Response code int statusCode = response.getStatusCode();
		 * System.out.println(statusCode);
		 * 
		 */

		// 2. digest Auth
		// RestAssured.baseURI = "https://postman-echo.com/digest-auth";
		// given().auth().digest("postman", "password").when().get().then().log().all();

		// generateBearerToken();
		// orderBookInSampleBookAPI();
		// getOrderDetails();

		String s = passingOfAPIKey();
		System.out.println("Coordinate of longtitude :" + s);
	}

}
