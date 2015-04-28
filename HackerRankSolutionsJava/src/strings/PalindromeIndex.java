package strings;

import java.util.Scanner;

public class PalindromeIndex {
	
	private static void makeAna(String inputString) {
        int i = 0;
        int j = inputString.length() - 1;
        StringBuilder sb = new StringBuilder(inputString);
        while (i <= j) {
            if (inputString.charAt(i) == inputString.charAt(j)) {
                i++;
                j--;
            } else {
                sb.deleteCharAt(i);
                if (checkSubStringForAnagram(sb.toString())) {
                    System.out.println(i);
                    return;
                } else {
                    System.out.println(j);
                    return;
                }
            }
        }
        System.out.println("-1");
    }

    private static boolean checkSubStringForAnagram(String subString) {
        int i = 0;
        int j = subString.length() - 1;
        while (i <= j) {
            if (subString.charAt(i) != subString.charAt(j)) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int looper = scanner.nextInt();
        scanner.nextLine();
        for(int i = 0; i < looper; i++) {
            makeAna(scanner.nextLine());
        }
        scanner.close();
    }

}
