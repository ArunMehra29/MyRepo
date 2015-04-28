package sorting;

import java.util.Arrays;
import java.util.Scanner;

public class FindTheMedian {
	
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        long[] longArray = new long[size];
        for(int i = 0; i < size; i++){
            longArray[i] = scanner.nextLong();
        }
        Arrays.sort(longArray);
        System.out.println(longArray[(size - 1)/2]);
        scanner.close();
    }

}
