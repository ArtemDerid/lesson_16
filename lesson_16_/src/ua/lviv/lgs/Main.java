package ua.lviv.lgs;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {

		System.out.println(
				"1. Створити довільний клас , описати його. Створити в мейн його екземпляр, дослідити всю інформацію про цього.");
		System.out.println();

		Class pc = Pet.class;

		String nameOfClass = pc.getName();
		System.out.println("This is class name ---> " + nameOfClass);

		int modifier = pc.getModifiers();
		String stringModifier = Modifier.toString(modifier);
		System.out.println("This is class modifier ---> " + stringModifier);

		Package package1 = pc.getPackage();
		System.out.println("This is package name ---> " + package1);

		Class superclass = pc.getSuperclass();
		System.out.println("This is superclass ---> " + superclass);

		Class[] interfaces = pc.getInterfaces();
		System.out.println("This is interface ---> " + Arrays.toString(interfaces));

		System.out.println();

		System.out.println("These are constructors:");

		Constructor<Pet>[] ClassConstructors = pc.getConstructors();
		for (int i = 0; i < ClassConstructors.length; i++) {
			Constructor<Pet> constructor = ClassConstructors[i];
			System.out.println(constructor);
		}

		System.out.println();

		System.out.println("These are public fields:");

		Field[] fields = pc.getFields();
		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			System.out.println(field);
		}

		System.out.println();

		System.out.println("These are all fields:");

		fields = pc.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			System.out.println(field);
		}

		System.out.println();

		System.out.println("These are methods:");

		Method[] methods = pc.getMethods();
		for (int i = 0; i < methods.length; i++) {
			Method method = methods[i];
			System.out.println(method);
		}

		System.out.println();
		System.out.println("2. Перезапишіть значення поля класу за допомогою рефлексії.");
		System.out.println();

		Constructor<Pet> singleConstructor = pc.getConstructor(String.class, int.class, String.class, double.class);

		Pet petNewInstance = singleConstructor.newInstance("Cat", 4, "Pussy", 4.8);
		System.out.println(petNewInstance);

		Field typeField = pc.getField("type");
		typeField.set(petNewInstance, "Dog");

		Field ageField = pc.getField("age");
		ageField.set(petNewInstance, 8);

		Field privateNameField = fields[2];
		privateNameField.setAccessible(true);
		privateNameField.set(petNewInstance, "Ruff");

		Field privateWeightField = fields[3];
		privateWeightField.setAccessible(true);
		privateWeightField.set(petNewInstance, 12.5);

		System.out.println(petNewInstance);

		System.out.println();
		System.out.println(
				"3. Створіть і викличте  методи  myMethod(String a, int ... args) та  myMethod(String … args) за допомогою рефлексії.");
		System.out.println();

		Method method = pc.getMethod("setTypeAndAge", new Class[] { String.class, int.class });
		Method method2 = pc.getMethod("newName", new Class[] { String.class });
		method.invoke(petNewInstance, "Rat", 5);
		method2.invoke(petNewInstance, "Cris");

		System.out.println(petNewInstance);
	}

}
