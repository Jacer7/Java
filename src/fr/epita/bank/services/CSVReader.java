package fr.epita.bank.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import fr.epita.bank.datamodel.Customer;
import fr.epita.bank.datamodel.SavingsAccount;

public class CSVReader {

	public  List<Customer> readFromFile(String filePath) throws IOException {
		List<String> lines = Files.readAllLines(new File(filePath).toPath());
		List<Customer> customers = new ArrayList<>();
		for (String line : lines){
			String[] parts = line.split(";");
			System.out.println(parts[0]);
			Customer currentCustomer = new Customer();
			currentCustomer.setName(parts[0]);
			currentCustomer.setAddress(parts[1]);
			customers.add(currentCustomer);
			SavingsAccount account = new SavingsAccount();
			account.setBalance(Double.valueOf(parts[2]));
			currentCustomer.setSavingsAccount(account);
		}
		return customers;
	}
}
