package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ClosestNumber {

	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        List<Long> list = new ArrayList<Long>(); 
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        long[] intArray = new long[length];
        for(int i = 0; i < length; i++) {
            intArray[i] = scanner.nextLong();
        }
        Arrays.sort(intArray);
        long minValue = intArray[length - 1] - intArray[length - 2];
        list.add(intArray[length -2]);
        list.add(intArray[length -1]);
        for(int x = length - 2; x > 0; x--) {
            if(minValue < intArray[x] - intArray[x-1]) {
                
            } else if(minValue == intArray[x] - intArray[x-1]) {
                list.add(intArray[x-1]);
                list.add(intArray[x]);
            } else {
                minValue = intArray[x] - intArray[x-1];
                list.clear();
                list.add(intArray[x-1]);
                list.add(intArray[x]);
            }
        }
        Collections.sort(list);
        for(Long num : list) {
            System.out.print(num + " ");
        }
    }
}
