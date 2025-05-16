package org.test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Test123 {

	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {

		ObjectMapper mp = new ObjectMapper();

		C1 readValue = mp.readValue(new File("C:\\Users\\sabas\\eclipse-workspace\\SampleAPIProject\\data.json"),
				C1.class);
		String companyName = readValue.getCompanyName();
		int compId = readValue.getCompId();
		long mobileNumber = readValue.getMobileNumber();
		System.out.println(companyName);
		System.out.println(compId);
		System.out.println(mobileNumber);

		List<C2> employees = readValue.getEmployees();

		// TO get information about employee we can go for iteration.
		// For doing iteration we can use for loop or for each

		for (C2 c2 : employees) {
			int id = c2.getId();
			System.out.println(id);

			String first_name = c2.getFirst_name();
			System.out.println(first_name);

			String department = c2.getDepartment();
			System.out.println(department);
		}

	}

}
