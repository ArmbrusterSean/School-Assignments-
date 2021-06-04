import java.util.Scanner;

/*Sean Armbruster 
 * CSC 251 420 
 * Recursion Project 
 * 
 * This program will use a recursive method that accepts a string as its argument and prints the
 * string in reverse order.
 */

public class recursiveProject
{

	public static void main(String[] args)
	{
		//Scanner Class and declare local variable for String input 
		Scanner input = new Scanner(System.in);
		String sentence;
		
        // prompt user for Sentence
		System.out.print("Enter a Sentence: ");
		sentence = input.nextLine();
		
		// call reverse method and print
		String newSentence = reverse(sentence);
		System.out.println("Your sentence in reverse is:" + newSentence);
		
		// close Scanner
		input.close();
	}//end main
	
	//The reverse method will check for input and use recursion to return the new value
    public static String reverse(String rev)
    {
    	//check for String
    	if(rev.isEmpty())
    		return rev;
    	//use recursion
    	return reverse(rev.substring(1)) + rev.charAt(0);	
	}// end reverse class

}// end class 
