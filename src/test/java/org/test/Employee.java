package org.test;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Supplier;

public class Employee {

	public Employee() {
		System.out.println("Employee Default constructor");
	}

	public Employee(String name, int id) {
		System.out.println("Constuctor Name is :" + name + " " + " id is :" + id);

	}

	public static void test(String name, int id) {
		System.out.println("Name is :" + name + " " + " id is :" + id);
		
	}

	public static void main(String[] args) {

		Supplier<Employee> e = Employee::new;
		Employee employee = e.get();

		BiFunction<String, Integer, Employee> e1 = Employee::new;
		Employee apply = e1.apply("Ramesh", 1000);

		

	}
}
