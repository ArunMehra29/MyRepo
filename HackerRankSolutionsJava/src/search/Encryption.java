package search;

import java.util.Scanner;

public class Encryption {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		int length = input.length();
		int gap = (int) Math.floor(Math.sqrt(length));
		int loop = (int) Math.ceil(Math.sqrt(length));
		int head = 0;
		if (gap == loop) {
			for (int y = 0; y < gap; y++) {
				for (int i = head; i < length; i += loop) {
					if (i < length) {
						System.out.print(input.charAt(i));
					} else {
						System.out.print("");
					}
				}
				System.out.print(" ");
				head++;
			}
		} else {
			for (int y = 0; y <= gap; y++) {
				for (int i = head; i < length; i += loop) {
					if (i < length) {
						System.out.print(input.charAt(i));
					} else {
						System.out.print("");
					}
				}
				System.out.print(" ");
				head++;
			}
		}
		scanner.close();
	}
}
