package org.test;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadJson {

	public static void main(String[] args) throws IOException {

		ObjectMapper map = new ObjectMapper();
		C1 readValue = map.readValue(new File("C:\\Users\\sabas\\eclipse-workspace\\SampleAPIProject\\data.json"),
				C1.class);

		int compId = readValue.getCompId();
		System.out.println(compId);
	}
}
