package strings;

import java.util.Scanner;

public class Panagrams {

	private static void checkPangram(String input) {
        if (input.length() < 26) {
            System.out.println("not pangram");
            return;
        }
        boolean[] pangramArray = new boolean[26];
        int counter = 26;
        int c = -1;
        for (int i = 0; i < input.length(); i++) {
            c = input.charAt(i);
            c = c - 97;
            if (!pangramArray[c]) {
                pangramArray[c] = true;
                counter--;
                if (counter == 0) {
                    System.out.println("pangram");
                    return;
                }
            }
        }
        if (counter > 0) {
            System.out.println("not pangram");
        } else {
            System.out.println("pangram");
        }
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        input = input.replace(" ","");
        input = input.toLowerCase();
        Panagrams.checkPangram(input);
        scanner.close();
    }
}
