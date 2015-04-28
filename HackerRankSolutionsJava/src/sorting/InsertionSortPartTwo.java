package sorting;

import java.util.Scanner;

public class InsertionSortPartTwo {
	
	public static void insertionSortPart2(int[] ar)
    {       
           // Fill up the code for the required logic here
           // Manipulate the array as required
           // The code for Input/Output is already provided
        int counter;
        for (int i = 1; i < ar.length; i++) {
            counter = i - 1;
            while (counter >= 0 && ar[counter + 1] < ar[counter])  {
                swapNeighbor(ar, counter, counter + 1);
                counter--;
            }
            printArray(ar);
        }
    }  
    
    public static void swapNeighbor(int[] ar, int indexFirstNumber, int indexSecondNumber) {
        int tempVariable = ar[indexFirstNumber];
        ar[indexFirstNumber] = ar[indexSecondNumber];
        ar[indexSecondNumber] = tempVariable;
    }
      
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
       int s = in.nextInt();
       int[] ar = new int[s];
       for(int i=0;i<s;i++){
            ar[i]=in.nextInt(); 
       }
       insertionSortPart2(ar);    
                    
    }    
    private static void printArray(int[] ar) {
      for(int n: ar){
         System.out.print(n+" ");
      }
        System.out.println("");
   }

}
