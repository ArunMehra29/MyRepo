package search;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class MissingNumbers {

	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int[] listA = new int[a];
        for (int i = 0; i < a; i++) {
            listA[i] = scanner.nextInt();
        }
        int number = -1;
        int b = scanner.nextInt();
        HashMap<Integer, Integer> listBMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < b; i++) {
            number = scanner.nextInt();
            if (null == listBMap.get(number)) {
                listBMap.put(number, 1);
            } else {
                listBMap.put(number, listBMap.get(number) + 1);
            }
        }
        int count = -1;
        for (int i = 0; i < a; i++) {
            number = listA[i];
            count = listBMap.get(number);
            count--;
            if (count == 0) {
                listBMap.remove(number);
            } else {
                listBMap.put(number, count);
            }
        }
        int[] finalArray = new int[listBMap.size()];
        Iterator<?> iterator = listBMap.entrySet().iterator();
        count = 0;
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            finalArray[count] = (Integer) entry.getKey();
            count++;
        }
        Arrays.sort(finalArray);
        for (int i : finalArray) {
            System.out.print(i + " ");
        }
        scanner.close();
    }
}
