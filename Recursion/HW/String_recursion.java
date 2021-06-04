//Evan Waddell 8-31-2020
//package string_recursion;
import java.util.Scanner;
public class String_recursion {

	public static void main(String[] args) {
		Scanner boop = new Scanner(System.in);
		String input;	
		//Gets word or phrase from user.
		System.out.println("Enter a word or phrase.");
		input=boop.nextLine();
		//Separate word or phrase into characters, stores in array.
		char storageArray[] = input.toCharArray();
		//Get length of array
		int length= storageArray.length;
		//Passes array and array length to recursive function.
		stringReverser(storageArray, length);
		//Close scanner
		boop.close();
	}
	public static void stringReverser(char[] str1, int count) {
		
		if (count>0) {
			//Print character
			System.out.print(str1[count-1]);
			stringReverser(str1,count-1);
		}
		else {
			System.out.println("\n");
		}
	}	
}