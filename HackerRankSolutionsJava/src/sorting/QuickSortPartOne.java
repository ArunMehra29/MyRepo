package sorting;

import java.util.Scanner;

public class QuickSortPartOne {
	
	static void partition(int[] ar) {
	    int pivot = ar[0];
	    int pivotPosition = -1;    
	        for (int i = 1; i < ar.length; i++) {
	            if (pivot >= ar[i]) {
	                pivotPosition = shiftArray(ar, i, pivotPosition); 
	            } else {
	                //to think here
	            }
	        }
	        
	        printArray(ar);
	 }

	static int shiftArray(int[] ar, int position, int pivotPosition) {
	      if (pivotPosition > -1) {
	          int temp = ar[position];
	          for (int i = position; i > pivotPosition; i--) {

	        	  ar[i] = ar[i - 1];
	          }
	          ar[pivotPosition] = temp;
	          return pivotPosition + 1;
	      } else {
	          int temp = ar[position];
	          pivotPosition = 0;
	          for (int i = position; i > pivotPosition; i--) {
	          ar[i] = ar[i - 1];
	          }
	          ar[pivotPosition] = temp;
	          return 1;
	      }
	}

	static void printArray(int[] ar) {
	   for(int n: ar){
	      System.out.print(n+" ");
	   }
	     System.out.println("");
	}
	 
	public static void main(String[] args) {
	     Scanner in = new Scanner(System.in);
	     int n = in.nextInt();
	     int[] ar = new int[n];
	     for(int i=0;i<n;i++){
	        ar[i]=in.nextInt(); 
	     }
	     partition(ar);
	     in.close();
	 }

}
