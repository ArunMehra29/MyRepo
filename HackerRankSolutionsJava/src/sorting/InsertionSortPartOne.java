package sorting;

import java.util.Scanner;

public class InsertionSortPartOne {
	
	public static void insertIntoSorted(int[] ar) {
        // Fill up this function
        int value = ar[ar.length - 1];
        boolean isSmallestElement = true;
        loop : for (int i = ar.length - 2; i >= 0; i--) {
            
                if (ar[i] > value) {
                    ar[i+1] = ar[i];
                    printArray(ar);
                } else {
                    ar[i + 1] = value;
                    printArray(ar);
                    isSmallestElement = false;
                    break loop;
                }
            
        }
        if(isSmallestElement) {
            ar[0] = value;
            printArray(ar);
        }
    }
    
    
/* Tail starts here */
     public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
         for(int i=0;i<s;i++){
            ar[i]=in.nextInt(); 
         }
         insertIntoSorted(ar);
    }
    
    
    private static void printArray(int[] ar) {
      for(int n: ar){
         System.out.print(n+" ");
      }
        System.out.println("");
   }

}
