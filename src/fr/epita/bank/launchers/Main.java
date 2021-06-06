package fr.epita.bank.launchers;


import java.util.Scanner;

import fr.epita.bank.datamodel.Customer;
import fr.epita.bank.datamodel.SavingsAccount;

public class Main {

	public static void main(String[] args) {


		System.out.println("Hello in my bank application");
		Customer customer = new Customer();
		Scanner scanner = new Scanner(System.in);
		System.out.println("please input the customer address");
		customer.setAddress(scanner.nextLine().trim());
		System.out.println("please input the customer name");
		customer.setName(scanner.nextLine().trim());
		//code a scenario where the customer will create a savings account
		//the savings account will be initialized with a initial balance
		//the customer will then withdraw some money from this account (choose the amounts)

		SavingsAccount savingsAccount = new SavingsAccount();
		System.out.println("Please enter initial balance");
		double initialBalance = scanner.nextDouble();
		savingsAccount.setBalance(initialBalance);

		try {
			savingsAccount.withDraw(10);

			savingsAccount.withDraw(-10);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("you have selected a bad amount, please retry");

		}

		System.out.println("Hi " + customer.getName() + ", how are you doing?");
		scanner.close();
	}
}
