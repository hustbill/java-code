package com.hustbill;

import java.lang.reflect.Field;
import java.util.List;

class Person {

	private int salary = 100;
	private int tips = 20;
	private int benefit = 25;
	private int cashBack = 30;
	
}

public class PojoDemo {

	public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

		int sum = 0;
		Person Person = new Person();
		Field[] allFields = Person.getClass().getDeclaredFields();

		for (Field each : allFields) {

			if (each.getType().toString().equals("int")) {

				Field field = Person.getClass().getDeclaredField(each.getName());
				field.setAccessible(true);

				Object value = field.get(Person);
				Integer i = (Integer) value;
				sum = sum + i;
			}

		}

		System.out.println("Sum :" + sum);
	}

}