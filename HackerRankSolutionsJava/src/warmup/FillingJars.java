package warmup;

import java.util.Scanner;

public class FillingJars {
	
public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int counter = scanner.nextInt();
		int looper = scanner.nextInt();
		double totalValue = 0;
		double a, b, k;
		for (int i = 0; i < looper; i++) {
			a = scanner.nextDouble();
			b = scanner.nextDouble();
			k = scanner.nextDouble();
			totalValue += ((b - a) + 1) * k;
		}
		System.out.println((long) (Math.floor(totalValue/counter)));
		scanner.close();
	}

}
