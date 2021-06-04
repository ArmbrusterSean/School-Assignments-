
import java.util.*;
import java.io.*;

public class Maps {

	public static void main(String[] args) {

		Scanner userInput = new Scanner(System.in);
		System.out.print("Enter input file name: ");
		String fileName = userInput.nextLine();
		TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>();

		int wordCounter = 0;
		try 
		{
			Scanner input = new Scanner(new File(fileName));
			while (input.hasNextLine()) {
				String line = input.nextLine();
				String[] word = line.split("[\\s+\\p{P}]");
				wordCounter = wordCounter + word.length;
				for (int i = 0; i < word.length; i++) {
					if (word[i].trim().length() > 0 && word[i].trim().matches("[A-Z|a-z]+")) {
						String key = word[i].toLowerCase();
						if (treeMap.get(key) != null) {
							int count = treeMap.get(key);
							count++;
							treeMap.put(key, count);
						} else {
							treeMap.put(key, 1);
						}
					}
				}
			}
			input.close();
		} 	catch (Exception ex) {
			ex.printStackTrace();
		}
		Set<Map.Entry<String, Integer>> entrySet = treeMap.entrySet();
		System.out.println("\nTotal words: " + wordCounter);

		for (Map.Entry<String, Integer> entry : entrySet) {
			System.out.println(entry.getValue() + "\t" + entry.getKey());
		}
		userInput.close();
	}
}