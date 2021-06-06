package fr.epita.bank.launchers;

import java.io.BufferedInputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainWithInOut {


	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int num1 = 0;
		int num2 = 0;
		try { //this is a try-catch block, we will discuss it further
			System.out.println("Type some integer");
			num1 = scanner.nextInt();
			System.out.println("Input 1 accepted");
			num2 = scanner.nextInt();
			System.out.println("Input 2 accepted");
		} catch (InputMismatchException e) {
			System.out.println("Invalid Entry");
		}
		System.out.println(num1);
		System.out.println(num2);
		scanner.close();
	}
}
