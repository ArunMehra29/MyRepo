package warmup;

import java.util.Scanner;

public class ChocolateFeast {
	
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i++){
            System.out.println(Solve(in.nextInt(), in.nextInt(), in.nextInt()));
        }
        in.close();
    }
    
    private static int Solve(int N, int C, int M){
        int numberOfChocolates = 0;
        int numberOfWrappers = 0;
        numberOfChocolates += N/C;
        numberOfWrappers = numberOfChocolates;
        while (numberOfWrappers >= M) {
			numberOfChocolates++;
			numberOfWrappers -= M - 1;
		} 
        return numberOfChocolates;
    }

}
