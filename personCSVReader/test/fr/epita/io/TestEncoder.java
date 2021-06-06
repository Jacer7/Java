package fr.epita.io;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import fr.epita.persons.datamodel.Person;
import fr.epita.persons.services.PersonCSVReader;
import fr.epita.persons.services.PersonNumericalEncoder;

public class TestEncoder {

	public static void main(String[] args) throws IOException {
		List<Person> persons = PersonCSVReader.readAll("./personCSVReader/persons.csv");
		int[][] matrix = new int[persons.size()][4];
		PersonNumericalEncoder encoder = new PersonNumericalEncoder();
		for (int i = 0; i < persons.size(); i++){
			matrix[i] = encoder.encode(persons.get(i));
		}
		System.out.println(Arrays.deepToString(matrix));
		int sexAtlineM = matrix[1][0];
		int sexAtlineF = matrix[4][0];
		if (sexAtlineF == 1 && sexAtlineM ==0){
			System.out.println("success");
		}else{
			System.out.println("failure");
		}

	}
}
