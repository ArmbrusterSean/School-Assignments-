/*
 * Linked List are linear data structures where the elements are not stored 
 * in contiguous locations and every element is a separate object with a data 
 * part and address part. The elements are linked using pointers and addresses. 
 * Each element is known as a node. Due to the dynamicity and ease of insertions 
 * and deletions, they are preferred over the arrays. It also has few disadvantages 
 * like the nodes cannot be accessed directly instead we need to start from the head 
 * and follow through the link to reach to a node we wish to access.
 */

import java.util.*; 
  
public class LinkedListExample 
{ 
    public static void main(String args[]) 
    { 
        // Creating object of class linked list 
        LinkedList<String> object = new LinkedList<String>(); 
  
        // Adding elements to the linked list 
        object.add("A"); 
        object.add("B"); 
        object.addLast("C"); 
        object.addFirst("D"); 
        object.add(2, "Z"); 
        object.add("F"); 
        object.add("G"); 
        System.out.println("Linked list : " + object); 
  
        // Removing elements from the linked list 
        
        object.remove("B"); 
        System.out.println("Linked list after remove B : " + object); 
        object.remove(3); 
        System.out.println("Linked list after remove 3 : " + object); 
        object.removeFirst(); 
        System.out.println("Linked list after remove first : " + object); 
        object.removeLast(); 
        System.out.println("Linked list after remove last : " + object); 
        //System.out.println("Linked list after deletion: " + object); 
  		
        
        // Finding elements in the linked list 
        
        boolean status = object.contains("E"); 
  
        if(status) 
            System.out.println("List contains the element 'E' "); 
        else
            System.out.println("List doesn't contain the element 'E'"); 
  		
        
        // Number of elements in the linked list 
        int size = object.size(); 
        System.out.println("Size of linked list = " + size); 
  
        // Get and set elements from linked list 
        
        Object element = object.get(2); 
        System.out.println("Element returned by get(2) : " + element); 
        object.set(2, "Y"); 
        System.out.println("Linked list after change (set 2 to Y) : " + object); 
       
        
        object.set(0, "AA");
        System.out.println("Linked list after replacing first item : " + object);
        
        System.out.println("Index of AA in Linked list is : " + object.indexOf("AA"));
        
        
        
        //Ways to print
        //Iterating LinkedList
        
        System.out.println("=== Iterate over a LinkedList using Iteration ===");
        Iterator<String> iterator=object.iterator();
        while(iterator.hasNext()){
          System.out.println(iterator.next());
        }
        
        System.out.println("=== Iterate over a LinkedList using Java 8 forEach and lambda ===");
        object.forEach(name -> {
            System.out.println(name);
        });
        
        System.out.println("\n=== Iterate over a LinkedList using simple for-each loop ===");
        for(String letters: object) {
            System.out.println(letters);
        }
        
        System.out.println("\n=== Iterate over a LinkedList using descendingIterator() ===");
        Iterator<String> descendingHumanSpeciesIterator = object.descendingIterator();
        while (descendingHumanSpeciesIterator.hasNext()) {
            String speciesName = descendingHumanSpeciesIterator.next();
            System.out.println(speciesName);
        }
        
        
    } 
} 