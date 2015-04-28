package search;

import java.util.Scanner;

public class CircleCity {
	
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for(int i = 0; i < testCases; i++) {
           calculate(scanner.nextLong(), scanner.nextLong()); 
        }
        scanner.close();
    }
    
    private static void calculate(long radius, long noOfStation) {
        int counter = 0;
        for(int i = 0; i < Math.sqrt(radius); i++){
            if(((Math.sqrt(radius - i*i)) % 1) == 0){
                counter++;
            }
        }
        if(counter * 4 > noOfStation) {
            System.out.println("impossible");
        } else {
            System.out.println("possible");
        }
    }

}
