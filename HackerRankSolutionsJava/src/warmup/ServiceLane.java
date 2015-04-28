package warmup;

import java.io.IOException;
import java.util.Scanner;

public class ServiceLane {

	public static void main(String[] args) throws IOException{
		int[] inputIntArray;
		Scanner scanner = new Scanner(System.in);
		int i = scanner.nextInt();
		int j = scanner.nextInt();
		inputIntArray = new int[i];
		for (int j2 = 0; j2 < inputIntArray.length; j2++) {
			inputIntArray[j2] = scanner.nextInt();
		}
		int startingPoint;
		int endingPoint;
		for (int k = 0; k < j; k++) {
			startingPoint = scanner.nextInt();
			endingPoint = scanner.nextInt();
			ServiceLane.findMin(startingPoint, endingPoint, inputIntArray);
		}
		scanner.close();
	}
	private static void findMin(int startingPoint, int endingPoint, int[] inputIntArray) {
		int minElement = -1;
		for (int i = startingPoint; i <= endingPoint; i++) {
			if (i == startingPoint) {
				minElement = inputIntArray[i];
			}
			if (minElement > inputIntArray[i]) {
				minElement = inputIntArray[i];
			}
		}
		System.out.println(minElement);
	}
}
