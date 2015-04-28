package warmup;

import java.util.Scanner;

public class IsFibo {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int NumberOfDigits = scanner.nextInt();
		
		for (int i = 0; i < NumberOfDigits; i++) {
			checkIsFibo(scanner.nextDouble());
		}
	}
	
	private static void checkIsFibo(double number) {
		if (Math.sqrt((5 * number * number) + 4) % 1 == 0 || Math.sqrt((5 * number * number) - 4) % 1 == 0) {
			System.out.println("IsFibo");
		} else {
			System.out.println("IsNotFibo");
		}
	}
}


