package fr.epita.persons.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import fr.epita.persons.datamodel.Person;

public class PersonCSVReader {

	public static List<Person> readAll(String filePath) throws IOException {
		List<String> lines = Files.readAllLines(new File("./personCSVReader/persons.csv").toPath());
		lines.remove(0);
		List<Person> persons = new ArrayList<>();
		for (String line : lines){
			String[] parts = line.split(",");
			//"Name", "Sex", "Age", "Height (in)", "Weight (lbs)"
			String name = formatStringValue(parts[0]);
			String sex = formatStringValue(parts[1]);
			Integer age = formatIntegerValue(parts[2]);
			Integer height = formatIntegerValue(parts[3]);
			Integer weight = formatIntegerValue( parts[4]);
			Person person = new Person(name,sex,age,height,weight);
			persons.add(person);
		}
		return persons;
	}

	private static String formatStringValue(String part) {
		return part.replaceAll("\"", "").trim();
	}

	private static Integer formatIntegerValue(String part) {
		return Integer.valueOf(part.trim());
	}
}
