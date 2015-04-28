package warmup;

import java.util.Scanner;

public class TheLoveLetterMystery {
	
	public static void main(String[] args) {

		int numberOfStrings;
		Scanner scanner = new Scanner(System.in);
		numberOfStrings = Integer.valueOf(scanner.nextLine());
		for (int i = 0; i < numberOfStrings; i++) {
			String inputString = scanner.nextLine();
			checkForPalindrome(inputString);
		}
		scanner.close();
	}

	private static void checkForPalindrome(String inputString) {
		int head;
		int tail;
		int operationsRequired = 0;
		head = 0;
		tail = inputString.length() - 1;
		while (head < tail) {
			operationsRequired += Math.abs(inputString.charAt(head) - inputString.charAt(tail));
			head++;
			tail--;
		}
		System.out.println(operationsRequired);
	}

}
