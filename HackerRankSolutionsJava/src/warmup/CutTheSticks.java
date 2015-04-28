package warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CutTheSticks {
	
	public static void main(String[] args) throws IOException{
    	Integer[] intArray = null;
    	String[] stringArray = null;
    	String inputString = "";
    	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    	int stickCount = Integer.valueOf(bufferedReader.readLine());
    	inputString = bufferedReader.readLine();
			stringArray = new String[stickCount];
			stringArray = inputString.split(" ");
			intArray = new Integer[stringArray.length];
			for (int i = 0; i < stringArray.length; i++) {
				intArray[i] = Integer.valueOf(stringArray[i]);
			}
			Arrays.sort(intArray);
			while (subtractStickLength(intArray)) {
				intArray = resizeArray(intArray);
			}
    }
    
    private static Integer[] resizeArray(Integer[] intArray) {
    	int i = 0;
    	forLoop: for (int j = 0; j < intArray.length; j++) {
			if (intArray[j] == 0) {
				i++;
			} else {
				break forLoop;
			}
		}
    	if (i > 0) {
    		Integer[] resizedArray = new Integer[intArray.length - i];
        	int counter = 0;
        	for (int j = i; j < intArray.length; j++) {
    			resizedArray[counter] = intArray[j];
    			counter++;
    		}
        	return resizedArray;
		} else {
			return null;
		}
    }
    
    private static boolean subtractStickLength(Integer[] intArray) {
    	int minusCounter = 0;
    	int minusValue;
    	if (intArray.length > 0) {
    		if (intArray[0] > 0) {
    			minusValue = intArray[0];
    			for (int i = 0; i < intArray.length; i++) {
    				intArray[i] = intArray[i] - minusValue;
    				minusCounter++;
    			}
    			System.out.println(minusCounter);
    		}
        	if (minusCounter > 0) {
    			return true;
    		} else {
    			return false;
    		}
		} else {
			return false;
		}
    }

}
