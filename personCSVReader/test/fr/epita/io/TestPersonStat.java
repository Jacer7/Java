package fr.epita.io;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import fr.epita.persons.datamodel.Person;
import fr.epita.persons.services.PersonCSVReader;
import fr.epita.persons.services.PersonNumericalEncoder;

public class TestPersonStat {

	public static void main(String[] args) throws IOException {
		List<Person> persons = PersonCSVReader.readAll("./personCSVReader/persons.csv");

		List<Person> males = persons.stream()
				.filter(p -> p.getSex().equals("M"))
				.collect(Collectors.toList());
		double[] averageVector = calculateAverage(males);
		for (double d: averageVector) {
			System.out.print(d+ " ");
		}
		System.out.println();
		List<Person> females = persons.stream()
				.filter(p -> p.getSex().equals("F"))
				.collect(Collectors.toList());

		averageVector = calculateAverage(females);
		for (double d: averageVector) {
			System.out.print(d+ " ");
		}


	}

	public static double[] calculateAverage(List<Person> persons){
		int[][] matrix = PersonNumericalEncoder.encode(persons);
		double[] averageVectorForMale = new double[4];
		for (int[] line :  matrix){
			for (int i = 0; i < 4; i++) {
				averageVectorForMale[i] = averageVectorForMale[i] + line[i] ;
			}
		}
		for (int i = 0; i < 4; i++) {
			averageVectorForMale[i] = averageVectorForMale[i] / matrix.length;
		}
		return averageVectorForMale;
	}
}
