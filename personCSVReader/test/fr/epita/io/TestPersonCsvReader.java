package fr.epita.io;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import fr.epita.persons.datamodel.Person;
import fr.epita.persons.services.PersonCSVReader;

public class TestPersonCsvReader {

	public static void main(String[] args) throws IOException {
		List<Person> persons = PersonCSVReader.readAll("./personCSVReader/persons.csv");

		List<String> possibleValuesForSex = Arrays.asList("M", "F");

		for (String value : possibleValuesForSex){
			long personsForCurrentValue = persons.stream()
					.filter(p -> p.getSex().equals(value))
					.count();
			System.out.println(value + ":" + personsForCurrentValue);
		}

		Map<String,Integer> distributionMap = new LinkedHashMap<>();

		//first method with map
		for (Person person : persons){
			String sex = person.getSex();
			Integer count = distributionMap.get(sex);
			if (count == null){
				count = 0;
			}
			count = count + 1;
			distributionMap.put(sex, count);
		}

		distributionMap.clear();

		//second method with map (does exactly the same)
		for (Person person : persons){
			String sex = person.getSex();
			Integer count = distributionMap.computeIfAbsent(sex, sexValue -> 0) + 1 ;
			distributionMap.put(sex, count);
		}

		distributionMap.clear();

		//have the distribution

		System.out.println("printing out the distribution across ages");
	//	persons.sort(Comparator.comparingInt(Person::getAge));

		for (Person person : persons){
			String ageAsString = String.valueOf(person.getAge());
			Integer count = distributionMap.computeIfAbsent(ageAsString, sexValue -> 0) + 1 ;
			distributionMap.put(ageAsString, count);
		}
		System.out.println(distributionMap);
		//option to sort on the map
		Set<String> strings = distributionMap.keySet();
		List<String> sortedKeys = new ArrayList<>(strings);
		sortedKeys.sort(Comparator.comparing(String::toString));
		sortedKeys.forEach(s -> {
			System.out.println(s + " : " + distributionMap.get(s));
		});


		System.out.println("displaying result sorted on values");
		Set<Map.Entry<String, Integer>> e = distributionMap.entrySet();
		List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(e);
		sortedEntries.sort((pair1,pair2)-> pair2.getValue().compareTo(pair1.getValue()));
		sortedEntries.forEach( pair -> 	System.out.println(pair.getKey() + " : " + pair.getValue()));






//		List<Person> males = persons.stream()
//				.filter(p -> p.getSex().equals("M"))
//				.collect(Collectors.toList());
//		List<Person> females = persons.stream()
//				.filter(p -> p.getSex().equals("F"))
//				.collect(Collectors.toList());
//
//		System.out.println("males : " + males.size());
//		System.out.println("females : " + females.size());
	}

}
