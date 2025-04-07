package labs.lab6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * A bank contains account numbers and balances of each customer.
 */
public class Bank {
	// ADD YOUR INSTANCE VARIABLES HERE

	ArrayList<BankAccount> accounts = new ArrayList<>();
	/**
	 * Construct a Bank object with accounts read from the given file
	 * 
	 * @param filename the name of the file
	 */
	public Bank(String fileName){
		// FILL IN
		try (Scanner inputFile = new Scanner(new File(fileName))) {
			while (inputFile.hasNext()) {
				accounts.add(new BankAccount(inputFile.nextInt(), inputFile.nextDouble()));
			}
		} catch (FileNotFoundException e) { System.out.print("File: " + fileName + " not found"); }
	}


	/**
	 * Gets the account with the lowest balance.
	 * 
	 * @return the account with the lowest balance, or null if there are
	 * no accounts in this bank
	 */
	public BankAccount getLowestBalanceAccount() {
		
		if (accounts.size() == 0) { return null; }
		else {
			BankAccount min = accounts.get(0);
			for (int i = 0; i < accounts.size(); i++) {
				if (accounts.get(i).getBalance() < min.getBalance()) {
					min = accounts.get(i);
				}
			}
			return min;
		}
	}
}
