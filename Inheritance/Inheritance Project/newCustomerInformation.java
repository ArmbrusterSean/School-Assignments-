import java.util.Scanner;

/* 
 * Sean Armbruster
 * Week 4 Inheritance Project 
 * CSC 251 420
 * 
 * This program uses inheritance to display prompted information and calculates a discounted price.
 */

public class newCustomerInformation
{

	public static void main(String[] args)
	{
		// create scanner class and fields
		Scanner input = new Scanner(System.in);
		String n; // name
		String a; // address
		String p; // phone number
		
		// prompt user for customer name/address/phone # 
		System.out.print("What is Your Name? ");
		n = input.nextLine();
	    System.out.print("What is Your Address? ");
	    a = input.nextLine();
	    System.out.print("What is Your Phone Number? ");
	    p = input.nextLine();
	    
		// instance variable for Person Class
		Customer cus = new Customer(n, a, p);
		
	    // Prompt is user wants to join the mailing list
	    System.out.println("\nDo You Wish to be on The Mailing List? Enter y/n: ");
		String yn = input.nextLine().trim().toLowerCase();
		if (yn.equals("y") && cus.isMailList()) {
			cus.setMailList(true);
		}
		else if (yn.equals("n")) {
			cus.setMailList(false);
			System.out.println("You are Not on The Mailing List.");
		}


	    // instance variable for Preferred Customer 
		PrefferedCustomer pref = new PrefferedCustomer(n, a, p);
		
		// prompt user for discount information 
		//calculated amount = PurchaseAMT - (PurchaseAMT * discountLVL
	    System.out.println("\nHow Much is Your Purchase? ");
	    double amnt = input.nextDouble(); 
	    double dsct = pref.getDiscountLVL();
	    pref.setPurchaseAMT(amnt);
	    double dTotal = pref.getPurchaseAMT();
	    double newAMNT = dTotal - (dTotal * dsct);
 
		// output the customer information
	    System.out.println("Customer Information:");
		System.out.printf("Customer Number:");
		//call for the customer number
		cus.getCustomerNum();
		
		System.out.println("\nName: " + cus._name + "\n" + 
		                   "Address: " + cus._address + "\n" + 
				           "Phone Number: " + cus._phone);
	
		// output the discounted rate
		System.out.printf("Your Disocunted Ammount is:$%.2f\n", newAMNT);

	}// end Main 
} // end Public Class 


class Person { // superclass 
	// define properties
	String _name;
	String _address;
	String _phone;
	
	// constructor 
	public Person(String name, String address, String phone) {
		_name = name;
		_address = address;
		_phone = phone; 
	}// end constructor
} // end person class 

	


class Customer extends Person{ // subclass
	
	// Constructor
	public Customer(String name, String address, String phone){
		super(name, address, phone);
	}// end constructor 
	

	//fields
	String customerNum;
	boolean mailList;
	
	//Getters and Setters for fields 
	public String getCustomerNum()
	{
        for(int i = 0; i < 5; i++){
            System.out.print((int)((Math.random() * 99) + 8));
        }
		return customerNum;
	}
	
	public void setCustomerNum(String customerNum)
	{
		this.customerNum = customerNum;
	}
	
	public boolean isMailList()
	{
		if (mailList = true) {
			System.out.println("You are on The Mailing List."); 
			return true;
		}
		else{
			return false;
		}
	}

	
	
	public void setMailList(boolean mailList)
	{
		this.mailList = mailList;
	}
	
	
}// end customer class 

class PrefferedCustomer extends Customer{

	// constructor
	public PrefferedCustomer(String name, String address, String phone)
	{
		super(name, address, phone);
	} // end constructor 
	
	// fields
	double purchaseAMT;
	double discountLVL;
	
	// getters and setters 
	public double getPurchaseAMT()
	{
		return purchaseAMT;
	}
	public void setPurchaseAMT(double purchaseAMT)
	{
		this.purchaseAMT = purchaseAMT;
	}
	public double getDiscountLVL()
	{
		if (purchaseAMT <= 500) {
			return discountLVL = 0.05;
		}
	    else if (purchaseAMT >= 501 && purchaseAMT <= 1000) {
			return discountLVL = 0.06;
		}
		else if(purchaseAMT >= 1001 && purchaseAMT <= 1500) {
			return discountLVL =  0.07;
		}
	    else if (purchaseAMT > 1500) {
			return discountLVL = 0.10;
	    }
	    else {
	    	return discountLVL;
	    }
		
	}
	public void setDiscountLVL(double discoutLVL)
	{
		this.discountLVL = discoutLVL;
	} 
	
		
}// end subclass 
