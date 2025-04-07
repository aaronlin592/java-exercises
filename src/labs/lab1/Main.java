package labs.lab1;

import java.math.BigInteger;
import java.util.Random;
import java.time.LocalDate;
import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.Locale;

public class Main {
	
	public static void main(String[] args) {
		
    }
	
	/**
	 * Given a string, return a new string where all the "e" letters and "o" letters,
	 *  as well as all the "E" letters and "O" letters have been switched, by 
	 *  calling the replace method. (Hint: You will have to call replace more than 
	 *  once.)
	 *  
	 * @param str	the input string
	 * 
	 * @return	a new string where all the "e" letters and "o" letters,
	 *  as well as all the "E" letters and "O" letters have been switched
	 */
	public static String problem1_switchEO(String str) {
		str = str.replace("o", "`");
		str = str.replace("e", "~");
		str = str.replace("O", "+");
		str = str.replace("E", "=");
		
		str = str.replace("`", "e");
		str = str.replace("~", "o");
		str = str.replace("+", "E");
		str = str.replace("=", "O");
		return str; // FIX ME
	}
	
	
	/**
	 * Given two strings, a and b, return true if b appears (in its entirety, 
	 * case-sensitive) starting at index 0 or 1 in a. String a may be any length, 
	 * including 0. String b's length will be at least 1. 
	 * 
	 * @param a	the first input string
	 * @param b	the second input string
	 * 
	 * @return	true if b appears (in its entirety, case-sensitive) starting at 
	 * index 0 or 1 in a
	 */
	public static boolean problem2_hasStr(String a, String b) {
		if (a.indexOf(b) == 1 || a.indexOf(b) == 0) {
			return true;
		}
		return false; // FIX ME
	}
	
	
	/**
	 * A slot machine has 4 reels and a number of possible pictures for each 
	 * reel. Most modern slot machines operate based on a random number 
	 * generator that determines which picture to show for each reel. Write a method 
	 * that generates random numbers for 4-reel slot machines. This method takes as 
	 * input numPics, and returns 4 numbers (indicating which picture to show in each
	 * reel) as a string, with each number separated by a space.
	 * 
	 * Construct an object of the Random class (see the Java API docs) and invoke an 
	 * appropriate method to generate each number. 
	 * 
	 * As an example, imagine you have a machine that has 3 possible pictures: 
	 * cherries (picture #1), bananas (picture #2), or money (picture #3).
	 * In this case, the result should contain 4 numbers between 1 and 3. For instance,
	 * "3 2 1 1", which would translate to:
	 * 
	 * Reel 1: money
	 * Reel 2: bananas
	 * Reel 3: cherries
	 * Reel 4: cherries
	 * 
	 * But all you have to return is a string with the numbers in it. The example
	 * with actual pictures of things is just for context.
	 * 
	 * Assume numPics will always be > 0.
	 * 
	 * @param numPics	the number of possible pictures per reel
	 * @return			a string that indicates which picture to show in each reel (4 numbers 
	 * 					separated by a single space
	 */
	public static String problem3_slotMachine(int numPics) {
		Random rnd = new Random();
		int num1 = rnd.nextInt(numPics) + 1;
		int num2 = rnd.nextInt(numPics) + 1;
		int num3 = rnd.nextInt(numPics) + 1;
		int num4 = rnd.nextInt(numPics) + 1;
		return num1 + " " + num2 + " " + num3 + " " + num4; // FIX ME
	}
	
	
	/**
	 * Given a BigInteger object, return a BigInteger that is equal to the original 
	 * BigInteger to the fourth power.
	 * 
	 * @param bigInt	the input BigInteger
	 * 
	 * @return	a BigInteger that is equal to the input BigInteger to the fourth power
	 */
	public static BigInteger problem4_bigPower(BigInteger bigInt) {
		return bigInt.pow(4); // FIX ME
	}
	
	
	/**
	 * Given three integers representing a date (month, day, and year), return a string
	 * indicating what day of the week that day falls on, in all upper case. The month,
	 * day, and year inputs will always represent a valid date.
	 * 
	 * Hint: See the LocalDate class in the Java API docs.
	 * 
	 * @param month	month of input date
	 * @param day	day of input date
	 * @param year	year of input date
	 * 
	 * @return	a string indicating what day of the week that day falls on, in all
	 * upper case
	 */
	public static String problem5_getDayOfWeek(int month, int day, int year) {
		LocalDate date = LocalDate.of(year, month, day);
		DayOfWeek dow = date.getDayOfWeek();
		
		return dow.getDisplayName(TextStyle.FULL, Locale.ENGLISH).toUpperCase(); // FIX ME
	}
}
