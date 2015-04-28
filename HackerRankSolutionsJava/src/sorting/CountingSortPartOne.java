package sorting;

import java.util.HashMap;
import java.util.Scanner;

public class CountingSortPartOne {

	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int looper = scanner.nextInt();
        int number;
        HashMap<Integer, Integer> countMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < looper; i++) {
            number = scanner.nextInt();
            if(null == countMap.get(number)) {
                countMap.put(number, 1);
            } else {
                countMap.put(number, countMap.get(number) + 1);
            }
        }
        for (int i  = 0; i < 100; i++) {
            if (null == countMap.get(i)) {
                System.out.print("0 ");
            } else {
                System.out.print(countMap.get(i) + " ");
            }
        }
        scanner.close();
    }
}
