package labs.lab2;

import java.util.Scanner;

public class Main {
	
	
	public static void main(String[] args) {
		
	}

	/**
	 * Extracts the dollars and cents from an amount of money given as a 
	 * floating-point value. For example, an amount 2.95 yields values 2 
	 * and 95 for the dollars the cents. 
	 * 
	 * You may assume that the input is always a valid non-negative monetary 
	 * amount.
	 * 
	 * @param amount amount of money
	 * 
	 * @return	a string representing the dollars and cents in the format 
	 * "dollars: ..., cents: ..."
	 */
	public static String problem1_getDollarsAndCents(double amount) {
		String strAmount = Double.toString(amount);
		String dollar = strAmount.substring(0, strAmount.indexOf("."));
		String cents = strAmount.substring(strAmount.indexOf(".") + 1);
		return "dollars: " + dollar + ", cents: " + cents; // FIX ME
	}
	
	
	/**
	 * Reads a ten-digit number from the user and prints it as a more readable
	 * string with parentheses and dashes. Specifically:
	 * 
	 * 1. Take the first three characters and surround them with "(" and ")". This
	 * is the area code. 2. Concatenate the area code, a single space, the next
	 * three characters, a hyphen, and the last four characters. This is the
	 * formatted number.
	 * 
	 * When you print the formatted number, use print instead of println.
	 * 
	 * Assume all input will be valid ten-digit numbers.
	 * 
	 * To run this method using the keyboard for user input, call it like this:
	 * problem2_formatPhoneNumber(new Scanner(System.in));
	 * 
	 * @param in the Scanner to be used for user input
	 * 
	 */
	public static void problem2_formatPhoneNumber(Scanner in) {
		// WRITE YOUR CODE HERE
		System.out.print("Please enter a ten-digit phone number: ");
		String phoneNumber = in.next();
		System.out.print("(" + phoneNumber.substring(0, 3) + ") " + phoneNumber.substring(3, 6) + "-" + phoneNumber.substring(6));
	}
	
	
	/**
	 * Computes the total of a sticker order based on the price per sticker and number
	 * of stickers, which are prompted for from the user
	 * 
	 * @param in the Scanner to be used for user input
	 * 
	 *           To run this method using the keyboard for user input, call it like
	 *           this: problem3_calculateTotal(new Scanner(System.in));
	 */
	public static void problem3_calculateTotal(Scanner in) {
		System.out.print("Enter price per sticker: ");
		double price = in.nextDouble();
		System.out.print("Enter the number of stickers: ");
		int number = in.nextInt();
		double subtotal = number * price;
		double shipping = 0.15 * number;
		double total = subtotal + (subtotal * 0.1) + shipping;
		String formattedTotal = String.format("%.2f", total);
		System.out.printf("Your total is: $" + formattedTotal);
		// WRITE YOUR CODE HERE
	}
	
	
	/**
	 * Computes the number of months it will take to pay off a credit card balance, based
	 * on the balance, APR, and monthly payment which are prompted for from the user
	 * 
	 * @param in the Scanner to be used for user input
	 * 
	 *           To run this method using the keyboard for user input, call it like
	 *           this: problem4_creditCardPayoff(new Scanner(System.in));
	 */
	public static void problem4_creditCardPayoff(Scanner in) {
		System.out.print("What is your balance? ");
		double balance = in.nextDouble();
		System.out.print("What is the APR on the card? ");
		double apr = (in.nextDouble() / 100) / 365;
		System.out.print("What is the monthly payment you can make? ");
		double monthlyPayment = in.nextDouble();
	
		double months = (-1.0/30) * ((Math.log(1.0+(balance/monthlyPayment) * (1.0-Math.pow(1+apr, 30))))/Math.log(1.0+apr));
		int nearestIntMonths = balance > 0 ? (int) (months + 1) : 0;
		System.out.print("It will take you " + nearestIntMonths + " months to pay off this card.");
		// WRITE YOUR CODE HERE
	}
	
	
	/**
	 * If one or both of the first 2 chars in the given string is the char 'x' 
	 * (lower case only), returns the string without those 'x' chars. Otherwise, 
	 * returns the string unchanged. 
	 * 
	 * @param str	the string to change
	 * 
	 * @return	the changed string
	 */
	public static String problem6_withoutX2(String str) {
		if (str.isEmpty()) {
			return "";
		}
		else if (str.charAt(0) == 'x' || str.charAt(1) == 'x') {
			if (str.length() > 2) {
				return str.substring(0, 2).replace("x", "") + str.substring(2);
			}
			else {
				return str.replace("x", "");
			}
		}
		else {
			return str;
		}
		 // FIX ME
	}
	
	
	/**
	 * Given 2 integer values greater than 0, return whichever value is nearest to
	 * 21 without going over. If they both go over, return 0.
	 * 
	 * @param a the first value
	 * @param b the second value
	 * 
	 * @return whichever value is nearest to 21 without going over; if they both go
	 *         over, return 0
	 */
	public static int problem7_playBlackjack(int a, int b) {
		boolean aOver21 = a > 21;
		boolean bOver21 = b > 21;
		
		if (aOver21 && bOver21) {
			return 0;
		}
		else if (bOver21 && !aOver21) {
			return a;
		}
		else if (aOver21 && !bOver21) {
			return b;
		}
		else {
			return a > b ? a : b;
		}
	 // FIX ME
	}
	
	
	/**
	 * Assesses the strength of a password based on these rules:
	 * 
	 * * A very weak password contains only digits and is fewer than eight characters
	 * * A weak password contains only letters and is fewer than eight characters
	 * * A strong password contains at least one letter and at least one digit and is at least
	 * eight characters
	 * * A very strong password contains at least one letter, at least one digit, and at least
	 * one special character (non letter or digit) and is at least eight characters
	 * * All other passwords are medium strength
	 * 
	 * Assume all input strings will have length >= 1
	 * 
	 * @param password	the password to assess
	 * @return	a string describing its strength
	 */
	public static String problem8_assessPasswordStrength(String password) {
		boolean isAlpha = false;
        boolean isNum = false;
        boolean hasSpecial = false;
        boolean isLengthy = password.length() >= 8;

        for (char c : password.toCharArray()) {
            if (Character.isLetter(c)) {
                isAlpha = true;
            } else if (Character.isDigit(c)) {
                isNum = true;
            } else {
                hasSpecial = true;
            }
        }
        
        if (!isAlpha && isNum && !hasSpecial && !isLengthy) {
        	return "very weak";
        }
        else if (isAlpha && !isNum && !hasSpecial && !isLengthy) {
        	return "weak";
        }
        else if (isAlpha && isNum && !hasSpecial && isLengthy) {
        	return "strong";
        }
        else if (isAlpha && isNum && hasSpecial && isLengthy) {
        	return "very strong";
        }
        else {
        	return "medium";
        }
        
	}
	
	
	/**
	 * Walk the user through troubleshooting issues with a car.
	 * 
	 * @param in the Scanner to be used for user input
	 * 
	 *           To run this method using the keyboard for user input, call it like
	 *           this: problem9_troubleshootCarIssues(new Scanner(System.in));
	 */
	public static void problem9_troubleshootCarIssues(Scanner in) {
		System.out.print("Is the car silent when you turn the key? ");
		String input = in.next();
		
		if (input.startsWith("y") || input.startsWith("Y")) {
			System.out.print("Are the battery terminals corroded? ");
			input = in.next();
			if (input.startsWith("y") || input.startsWith("Y")) {
				System.out.print("Clean terminals and try starting again");
			}
			else if (input.startsWith("n") || input.startsWith("N")) {
				System.out.print("Replace cables and try again.");
			}
			else {
				System.out.print("Invalid input. Exiting.");
			}
		}
		else if (input.startsWith("n") || input.startsWith("N")) {
			System.out.print("Does the car make a clicking noise? ");
			input = in.next();
			if (input.startsWith("y") || input.startsWith("Y")) {
				System.out.print("Replace the battery.");
			}
			else if (input.startsWith("n") || input.startsWith("N")) {
				System.out.print("Does the car crank up but fail to start? ");
				input = in.next();
				if (input.startsWith("y") || input.startsWith("Y")) {
					System.out.print("Check spark plug connections.");
				}
				else if (input.startsWith("n") || input.startsWith("N")) {
					System.out.print("Does the engine start and then die? ");
					input = in.next();
					if (input.startsWith("y") || input.startsWith("Y")) {
						System.out.print("Does your car have fuel injection? ");
						input = in.next();
						if (input.startsWith("y") || input.startsWith("Y")) {
							System.out.print("Get it in for service.");
						}
						else if (input.startsWith("n") || input.startsWith("N")) {
							System.out.print("Check to ensure the choke is opening and closing.");
						}
						else {
							System.out.print("Invalid input. Exiting");
						}
					}
					else if (input.startsWith("n") || input.startsWith("N")) {
						System.out.print("Get it in for service.");
					}
					else {
						System.out.print("Invalid input. Exiting.");
					}
				}
				else {
					System.out.print("Invalid input. Exiting.");
				}
			}
			else {
				System.out.print("Invalid input. Exiting.");
			}
			
		}
		else {
			System.out.print("Invalid input. Exiting.");
		}
		// WRITE YOUR CODE HERE
	}
}
