package warmup;

import java.util.Scanner;

public class UtopianTree {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int count = scanner.nextInt();
		for (int i = 0; i < count ; i++) {
			getNewTreeHeight(scanner.nextInt());
		}
		scanner.close();
	}
	
	private static void getNewTreeHeight(int cycle) {
		int originTreeHeight = 1;
		for (int i = 1; i <= cycle; i++) {
			if (i % 2 != 0) {
				originTreeHeight += originTreeHeight;
			} else {
				originTreeHeight += 1;
			}
		}
		System.out.println(originTreeHeight);
	}

}
