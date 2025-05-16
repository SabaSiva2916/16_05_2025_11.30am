package org.pjo;

import com.github.javafaker.Faker;

public class Book {
	public static void main(String[] args) {

		Faker f = new Faker();
		String firstName = f.name().firstName();
		int numberBetween = f.number().numberBetween(1, 10);
		String emailAddress = f.internet().emailAddress();
		System.out.println(firstName);
		System.out.println(numberBetween);
		System.out.println(emailAddress);

	}
}
