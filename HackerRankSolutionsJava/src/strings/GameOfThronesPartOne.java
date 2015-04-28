package strings;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class GameOfThronesPartOne {
	
static HashMap<Character, Integer> hashmap = new HashMap<Character, Integer>();
	
	public static void main(String[] args) throws IOException{
		
		Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine();
		if (isStringLengthEven(string.length())) {
			checkPalindromeForEven(string);
		} else {
			checkPalindromeForOdd(string);
		}
		scanner.close();
	}
	
	private static boolean isStringLengthEven(int length) {
		return (length % 2) == 0 ? true : false; 
	}
	
	private static void checkPalindromeForEven(String inputString) {
		if (hashmap.size() > 0) {
			hashmap.clear();
		}
		Character c;
		Integer value;
		Map.Entry<Character, Integer> object;
		for (int i = 0; i < inputString.length(); i++) {
			c = inputString.charAt(i);
			if (hashmap.containsKey(c)) {
				value = hashmap.get(c);
				hashmap.put(c, value + 1);
			} else {
				hashmap.put(c, 1);
			}
		}
		boolean isStringPalindrome = true;
		Iterator iterator = hashmap.entrySet().iterator();
		while (iterator.hasNext()) {
			object = (Map.Entry<Character, Integer>) iterator.next();
			if ((object.getValue() % 2) != 0) {
				isStringPalindrome = false;
				break;
			}
		}
		if (isStringPalindrome) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
	
	private static void checkPalindromeForOdd(String inputString) {
		if (hashmap.size() > 0) {
			hashmap.clear();
		}
		Character c;
		Integer value;
		Map.Entry<Character, Integer> object;
		boolean isOddValueFound = false;
		for (int i = 0; i < inputString.length(); i++) {
			c = inputString.charAt(i);
			if (hashmap.containsKey(c)) {
				value = hashmap.get(c);
				hashmap.put(c, value + 1);
			} else {
				hashmap.put(c, 1);
			}
		}
		boolean isStringPalindrome = true;
		Iterator iterator = hashmap.entrySet().iterator();
		while (iterator.hasNext()) {
			object = (Map.Entry<Character, Integer>) iterator.next();
			if ((object.getValue() % 2) != 0 && !isOddValueFound) {
				isOddValueFound = true;
			} else if((object.getValue() % 2) == 0) {
				//to do nothing here
			}  else {
				isStringPalindrome = false;
				break;
			}
		}
		if (isStringPalindrome) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
	

}
