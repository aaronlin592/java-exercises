package labs.lab6;

/**
 * A bank account has a balance that can be changed by deposits and withdrawals.
 */
public class BankAccount {
	// ADD YOUR INSTANCE VARIABLES HERE

	private int accountNumber;
	private double balance;
	/**
	 * Constructs a bank account with a given balance.
	 * 
	 * @param initialBalance the initial balance
	 */
	public BankAccount(int accountNumber, double initialBalance) {
		// FILL IN
		this.accountNumber = accountNumber;
		this.balance = initialBalance;
	}

	/**
	 * Gets the current balance of the bank account.
	 * 
	 * @return the current balance
	 */
	public double getBalance() {
		return balance; // FIX ME
	}
	
	public void setBalance(double balance) {
		// FILL IN
		this.balance = balance;
	}

	/**
	 * Gets the account number of the bank account.
	 * 
	 * @return the account number
	 */
	public int getAccountNumber() {
		return accountNumber; // FIX ME
	}
	
	
	/**
	 * Returns a string containing the account number and balance, separated by 
	 * a comma and space
	 */
	@Override
	public String toString() {
		return accountNumber + " " + balance; // FIX ME
	}
	
	
	/**
	 * Returns true if the given object is a BankAccount with the same instance
	 * variable values as this one
	 */
	@Override
	public boolean equals(Object otherObj) {
		BankAccount other = (BankAccount) otherObj;
		return accountNumber == other.accountNumber && balance == other.balance; // FIX ME
	}
}
