package org.pjo;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Test123 {

	// Authorization -->
	// Basi Auth Digest Auth --> auth(). basis() Or digest()

	// Bearear token --> We need to pass along with headers

	@Test(description = "Ordering Books")
	private void tc01(ITestContext context) {

		JSONObject obj = new JSONObject();
		obj.put("bookId", 1);
		obj.put("customerName", "Subash");

		Response post = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer 0494a7350f7c805a1aa426e5fccf95bffeef1d26561ff40cde829d99297a33ca")
				.body(obj.toString()).when().post("https://simple-books-api.glitch.me/orders");

		System.out.println(post.getStatusCode());
		System.out.println(post.getBody().asPrettyString());

		String orderId = post.jsonPath().get("orderId").toString();
		context.setAttribute("orderId", orderId);
	}

	@Test(description = "Getting order information")
	private void tc02(ITestContext context) {

		String orderId = context.getAttribute("orderId").toString();

		Response post = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer 0494a7350f7c805a1aa426e5fccf95bffeef1d26561ff40cde829d99297a33ca")
				.when().get("https://simple-books-api.glitch.me/orders/" + orderId);

		System.out.println(post.getStatusCode());
		System.out.println(post.getBody().asPrettyString());
	}

	@Test(description = "Update Customer info for previous order")
	private void tc03(ITestContext context) {
		String string = context.getAttribute("orderId").toString();

		JSONObject obj = new JSONObject();
		obj.put("customerName", "Praveen");

		Response post = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer 0494a7350f7c805a1aa426e5fccf95bffeef1d26561ff40cde829d99297a33ca")
				.body(obj.toString()).when().patch("https://simple-books-api.glitch.me/orders/" + string);

		System.out.println(post.getStatusCode());
		System.out.println(post.getBody().asPrettyString());
	}

	@Test(description = "Delete Order")
	private void tc04(ITestContext context) {
		String string = context.getAttribute("orderId").toString();

		Response post = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer 0494a7350f7c805a1aa426e5fccf95bffeef1d26561ff40cde829d99297a33ca")
				.when().delete("https://simple-books-api.glitch.me/orders/" + string);
		System.out.println(post.getStatusCode());
		System.out.println(post.getBody().asPrettyString());
	}

	@Test(description = "Confirm order is deleted or not")
	private void tc05(ITestContext context) {
		String string = context.getAttribute("orderId").toString();

		Response post = RestAssured.given().header("Content-Type", "application/json")
				.header("Authorization", "Bearer 0494a7350f7c805a1aa426e5fccf95bffeef1d26561ff40cde829d99297a33ca")
				.when().get("https://simple-books-api.glitch.me/orders/" + string);

		System.out.println(post.getStatusCode());
		System.out.println(post.getBody().asPrettyString());
	}

	@Test(description = "Reqres Get list of users")
	private void tc06() {
		RestAssured.baseURI = "https://reqres.in/api/users/2";
		Response response = given().header("x-api-key", "reqres-free-v1").when().get();
		System.out.println(response.getBody().asPrettyString());
		System.out.println(response.getStatusCode());
	}

}
