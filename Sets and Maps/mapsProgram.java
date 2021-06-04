import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/*
 * Sean Armbruster  
 * CSC 251 420 
 * Week 5 Map Program
 * 
 * This program reads a .txt file and uses maps to list the words 
 * and the number of occurrences of each word. The program will count the words in a 
 * case sensitive fashion and will not include punctuation. The output will be displayed in 
 * alphabetical order.
 * 
 */

public class mapsProgram
{

	public static void main(String[] args) throws FileNotFoundException
	{
		// Create Tree to store and sort words in alphabetical order 
		TreeMap<String, Integer> map = new TreeMap<>();
		
		// create Scanner to read the file 
		Scanner file = new Scanner (new File("gettys.txt"));
		
		// loop through the .txt and find the number of words minus punctuation & ignoring capitalization 
		while (file.hasNext()) {
			String word = file.next().trim().toLowerCase().replaceAll("\\p{Punct}","");
			if (map.containsKey(word)) {
				int numOfWords = map.get(word) + 1;
				map.put(word,numOfWords);
			}// end If 
			else {
				map.put(word,1);
			}// end else
		}// end While
		
		// close file 
		file.close();
		
		// iterate through the file and print the words in an Entry Set
		for(Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println(entry);
		}// end for 
		
	}// end Main

}// end Class