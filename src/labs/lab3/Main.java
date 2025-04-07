package labs.lab3;

import java.util.Arrays;
import java.util.Scanner;


public class Main {
	
	
	public static void main(String[] args) {
		
	}

	/**
	 * Takes a string as a parameter and returns a string where every appearance of
	 * the lowercase word "are" has been replaced with "are not". The word "are"
	 * should not be immediately preceded or followed by a letter -- so for example
	 * the "are" in "care" or "scared" does not count. (Note:
	 * Character.isLetter(char) tests if a char is a letter.)
	 * 
	 * @param str the string to replaces "are"s in
	 * @return the string with all "are"s replaced with "are not"s.
	 */
	public static String problem1_replace(String str) {
		return str.replaceAll("(?<![a-zA-Z])are(?![a-zA-Z])", "are not"); // FIX ME
	}
	
	
	/**
	 * Given a string, returns the length of the largest "block" in the string. A
	 * block is a run of adjacent chars that are the same.
	 * 
	 * @param str the string to check for blocks
	 * 
	 * @return the length of the largest block in the string
	 */
	public static int problem2_maxBlock(String str) {
		if (str.isEmpty()) {
            return 0;
        }
        
        int max = 1;
        int current = 1;
        
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                current++;
            } 
            else {
                max = Math.max(max, current);
                current = 1;
            }
        }
        
        max = Math.max(max, current);
        
        return max; // FIX ME
	}
	
	
	/**
	 * Given a string, return the longest substring that appears at both the
	 * beginning and end of the string without overlapping.
	 * 
	 * @param str the input string
	 * @return the longest substring that appears at both the beginning and end of
	 *         the string without overlapping.
	 */
	public static String problem3_sameEnds(String str) {
		int n = str.length();
        
        for (int i = n / 2; i > 0; i--) {
            String prefix = str.substring(0, i);
            String suffix = str.substring(n - i);
            
            if (prefix.equals(suffix)) {
                return prefix;
            }
        }
        
		return ""; // FIX ME
	}
	
	
	/**
	 * Manages crowd control in an office
	 * 
	 * @param in       the Scanner to be used for user input
	 * @param capacity of the office
	 * 
	 *                 To run this method using the keyboard for user input, call it
	 *                 like this: problem5_officeCrowdControl(new Scanner(System.in), 100);
	 */
	public static void problem5_officeCrowdControl(Scanner in, int capacity) {
		// WRITE YOUR CODE HERE
		System.out.print("People entering or leaving: ");
		int people = in.nextInt();
		do {
			System.out.print("People in office: " + people + " | People entering or leaving: ");
			int current = people;
			people = in.nextInt();
			if (people + current <= capacity) {
				people = (people + current) < 0 ? current : people + current;
			}
			else {
				people = current;
			}
		}
		while (people < capacity);
		System.out.print("People in office: " + capacity + " | Office is full");
	}
	
	
	/**
	 * Given a non-empty array of ints, returns a new array containing the elements from
	 * the original array that come after the last occurrence of the number 3 in the original
	 * array
	 * 
	 * @param nums	the input array
	 * 
	 * @return	a new array containing the elements from the original array that come after 
	 * the last occurrence of the number 3 in the original array
	 * 
	 */
	public static int[] problem6_post3(int[] nums) {
		int threeIndex = -1;
		
		for (int i = nums.length - 1; i >= 0; i--) {
			if (nums[i] == 3) {
				threeIndex = i;
				break;
			}
		}
		if (threeIndex == -1) {
			return new int[] {};
		}
		else {
			return Arrays.copyOfRange(nums, threeIndex + 1, nums.length);
		} // FIX ME
	}
	
	
	/**
	 * Given an integer n >= 0, returns an array with the pattern {1, 1, 2, 1, 2, 3,
	 * ... 1, 2, 3 .. n} (spaces added to show the grouping). Note that the length
	 * of the array will be 1 + 2 + 3 ... + n, which is known to sun to exactly n*(n
	 * + 1)/2.
	 * 
	 * @param n input integer
	 * 
	 * @return patterned array
	 */
	public static int[] problem7_arrayPattern(int n) {
		int[] newArray = new int[n*(n + 1)/2];
		int index = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				newArray[index] = j;
				index++;
			}
		}
		return newArray; // FIX ME
	}
}