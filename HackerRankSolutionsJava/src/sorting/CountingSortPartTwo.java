package sorting;

import java.util.Arrays;
import java.util.Scanner;

public class CountingSortPartTwo {
	
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int looper = scanner.nextInt();
        int[] array = new int[looper];
        for (int i = 0; i < looper; i++) {
            array[i] = scanner.nextInt();
        }
        Arrays.sort(array);
        for (int i : array) {
            System.out.print(i + " ");
        }
        scanner.close();
    }

}
