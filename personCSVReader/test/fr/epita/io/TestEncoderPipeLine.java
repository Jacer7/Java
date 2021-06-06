package fr.epita.io;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import fr.epita.persons.datamodel.Person;
import fr.epita.persons.services.PersonCSVReader;
import fr.epita.persons.services.PersonNumericalEncoder;

public class TestEncoderPipeLine {

	public static void main(String[] args) throws IOException {
		List<Person> persons = PersonCSVReader.readAll("./personCSVReader/persons.csv");
		List<int[]> matrix =  persons.stream()
				.map(PersonNumericalEncoder::encode)
				.collect(Collectors.toList());
		System.out.println(Arrays.deepToString(matrix.toArray()));


	}
}
