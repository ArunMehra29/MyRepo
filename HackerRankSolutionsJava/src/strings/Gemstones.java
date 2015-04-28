package strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Gemstones {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException{
		int c;
		HashMap<Integer, Character> charHashMap = new HashMap<Integer, Character>();
		List<String> stringList = new ArrayList<String>();
		BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
		int gemStonesCount = Integer.parseInt(bufferReader.readLine());
		for (int i = 0; i < gemStonesCount; i++) {
			stringList.add(bufferReader.readLine());
		}
		Map.Entry<Integer, Character> object = null;
		outerLoop: for (int i = 0; i < stringList.size(); i++) {
			for (int j = 0; j < stringList.get(i).length(); j++) {
				c = stringList.get(i).charAt(j);
					if (i == 0) {
						if (null == charHashMap.get(c)) {
							charHashMap.put(c, stringList.get(i).charAt(j));
						}
					} else {
						break outerLoop;
					}
			}
		}
		boolean isElementPresent = false;
		List<Integer> objectsToRemove = new ArrayList<Integer>();
		Iterator<?> iterator;
		for (int i = 1; i < stringList.size(); i++) {
			iterator = charHashMap.entrySet().iterator();
			while (iterator.hasNext()) {
				isElementPresent = false;
				object = (Map.Entry<Integer, Character>) iterator.next();
				for (int j = 0; j < stringList.get(i).length(); j++) {
					if (object.getValue().equals(stringList.get(i).charAt(j))) {
						isElementPresent = true;
						break;
					}
				}
				if (!isElementPresent) {
					objectsToRemove.add(object.getKey());
				}
			}
			for (Integer integer : objectsToRemove) {
				charHashMap.remove(integer);
			}
			if (objectsToRemove.size() > 0) {
				objectsToRemove.clear();
			}
		}
		System.out.println(charHashMap.size());
	}

}
