package org.test;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SampleAPI {

	public static void main(String[] args) throws StreamWriteException, DatabindException, IOException {

		// ObjectMapper --> C from jackson databind maven dependency
		ObjectMapper mp = new ObjectMapper();
		// Read data form JSON
		TestData readValue = mp.readValue(new File("C:\\Users\\sabas\\eclipse-workspace\\SampleAPIProject\\test.json"),
				TestData.class);
		String job = readValue.getJob();

		System.out.println(job);
	}
}
