package strings;

import java.util.Scanner;

public class Anagram {
	
	public static void makeAna(String inputString) {
        if (inputString.length() % 2 != 0) {
            System.out.println("-1");
            return;
        }
        int stringLength = inputString.length();
        int changes = 0;
        int char1 = -1;
        boolean isCharFound = false;
        String firstString = inputString.substring(0, (stringLength/2) );
        StringBuilder sb1 = new StringBuilder(inputString.substring(stringLength/2, stringLength));
        for (int i = 0; i < firstString.length(); i++) {
        	char1 = firstString.charAt(i);
        	isCharFound = false;
        	innerLoop : for(int j = 0; j < sb1.length(); j++) {
        		if (char1 == sb1.charAt(j)) {
        			sb1.deleteCharAt(j);
        			isCharFound = true;
        			break innerLoop;
        		}
        	}
        	if (!isCharFound) {
        		changes++;
        	}
        }
        System.out.println(changes);
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int looper = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < looper; i++) {
            makeAna(scanner.nextLine());
        }
        scanner.close();
    }

}
