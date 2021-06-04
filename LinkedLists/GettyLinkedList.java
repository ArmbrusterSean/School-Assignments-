/** 
 * Sean Armbruster 
 * CSC 251 420
 * Linked List Program Homework Assignment 
 * 
 * This program reads the text from the gettys.txt as a Linked List, then:
 * 1: Prints out the entire object
 * 2: Add the words "If you want to know what a person is like take a good look at how the person treats inferiors not equals" to the end of the linked list.
 * 3: Remove the 6th word - "ago"
 * 4: Replace all occurrences of the word "nation" to "country"
 * 5: Replace all occurrences of the word "that" to "this"
 * 6: Remove all occurrences of the word "and"
 * 7: Print out the entire object again to view all changes
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class GettyLinkedList
{

	public static void main(String[] args) throws FileNotFoundException
	{

	    // creating Scanner to read the file 
		Scanner file = new Scanner (new File("C:\\Users\\ACER\\Desktop\\gettys.txt"));
		
        // Creating object of class linked list 
        LinkedList<String> object = new LinkedList<String>(); 
         
        /** Read the file as a Linked List with each word being a different Node **/
        while(file.hasNext()) {
            String read = file.next();
        	object.add(read);
        }// end while 
        
        /** iterate through the linked list and print the results **/
        for(String letters: object) {
            System.out.print(letters + " ");
        }// end for 
        System.out.println(" ");
        
        /** Add the words:"If you want to know what a person is like take a good look at how the person treats inferiors not equals"
        *  to the end of the linked list. **/
        object.add("If you want to know what a person is like take a good "
        		+ "look at how the person treats inferiors not equals");
        
        /** Remove the 6th word - "ago" **/
        object.remove(5);

        /** Replace all occurrences of the word "nation" to "country" **/
        Collections.replaceAll(object, "nation", "country");
        Collections.replaceAll(object, "nation,", "country");

        
        /** Replace all occurrences of the word "that" to "this" **/
        Collections.replaceAll(object, "that", "this");

        /** Remove all occurrences of the word "and" **/
        object.remove("and");

        /** iterate through the linked list and print the new results **/
        for(String letters: object) {
            System.out.print(letters + " ");
        }// end for 
        
		// close file 
		file.close();

	}// end main
	
	

} // end GettyLinkedList Class 
