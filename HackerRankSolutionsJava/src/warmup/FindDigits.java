package warmup;

import java.util.Scanner;

public class FindDigits {
	
	public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	int counter = scanner.nextInt();
	for (int i = 0; i < counter; i++) {
		digitsDivisible(scanner.nextInt());
	}
	scanner.close();
}

private static void digitsDivisible(int number) {
	int digits = 0;
	int singleDigit;
	int temp = number;
	while (temp > 0) {
		singleDigit = temp % 10;
		if ((singleDigit > 0) && ((number % singleDigit) == 0)) {
			digits++;
		}
		temp = temp / 10;
	}
	System.out.println(digits);
}

}
