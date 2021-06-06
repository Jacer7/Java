package fr.epita.bank.test;

import java.io.IOException;
import java.util.List;

import fr.epita.bank.datamodel.Customer;
import fr.epita.bank.services.CSVReader;

public class TestCSVReader {

	public static void main(String[] args) throws IOException {
		CSVReader reader = new CSVReader();
		List<Customer> customers = reader.readFromFile("./test/customers.csv");
		System.out.println(customers);
	}
}
