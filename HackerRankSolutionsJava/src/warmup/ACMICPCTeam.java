package warmup;

import java.util.Scanner;

public class ACMICPCTeam {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] inputArray;
		int counter = scanner.nextInt();
		scanner.nextInt();
		inputArray = new String[counter];
		scanner.nextLine();
		for (int i = 0; i < inputArray.length; i++) {
			inputArray[i] = scanner.nextLine();
		}
		solve(inputArray);
		scanner.close();
	}
	
	private static void solve(String[] inputArray) {
		int value = 0;
		int maxValue = 0;
		int NumberOfMaxValueTeams = 0;
		for (int i = 0; i < inputArray.length; i++) {
			for (int x = i + 1; x < inputArray.length; x++) {
				value = 0;
				for (int k = 0; k < inputArray[x].length(); k++) {
					if ((((int) inputArray[i].charAt(k)) | ((int) inputArray[x].charAt(k))) == 49) {
						value ++;
					}
				}
				if (value > maxValue) {
					maxValue = value;
					NumberOfMaxValueTeams = 1;
				} else if (value == maxValue){
					NumberOfMaxValueTeams++;
				}
			}
		}
		System.out.println(maxValue);
		System.out.println(NumberOfMaxValueTeams);
	}

}
