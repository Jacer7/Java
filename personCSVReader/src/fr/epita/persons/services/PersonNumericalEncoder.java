package fr.epita.persons.services;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import fr.epita.persons.datamodel.Person;

public class PersonNumericalEncoder {

	private static Map<String,Integer> sexEncoding = new LinkedHashMap<>();
	static {
		sexEncoding.put("M",0);
		sexEncoding.put("F",1);
	}

	public static int[][] encode(List<Person> persons){
		return persons.stream()
				.map(PersonNumericalEncoder::encode).toArray(int[][]::new);
	}

	public static int[] encode(Person person) throws IllegalArgumentException {
		int[] result = new int[4];
		Integer resolvedValue = sexEncoding.get(person.getSex());
		if (resolvedValue == null){
			throw new IllegalArgumentException("sex value for entry : "+ person + " is not correctly defined");
		}
		result[0] = resolvedValue;
		result[1] = person.getAge();
		result[2] = person.getHeight();
		result[3] = person.getWeight();
		return result;
	}
}
