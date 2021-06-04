import java.util.Scanner;

/* Person Superclass
 * Customer Subclass
 * PreferredCustomer Subclass
 */

public class inheritanceCustomer {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("1. Enter customer name: ");
		String name = input.nextLine();
		System.out.print("2. Enter customer address: ");
		String address = input.nextLine();
		System.out.print("3. Enter customer phone number: ");
		String number = input.nextLine();
		PreferredCustomer newCustomer = new PreferredCustomer(name, address, number);
		
		System.out.print("4. Enter customer number: ");
		String cNumber = input.nextLine();
		newCustomer.setCNumber(cNumber);
		
		System.out.print("5. Would the customer like to recieve mail? (Y/N): ");
		String mail = input.nextLine();
		
		// input validation
		while (!mail.equals("Y") && !mail.equals("N")) {
			System.out.println("\nError: Please enter either Y or N.");
			System.out.print("5. Would the customer like to recieve mail? (Y/N): ");
			mail = input.nextLine();
		}
		if (mail.equals("Y")) {newCustomer.setMailList(true);}
		else {newCustomer.setMailList(false);}
		
		System.out.print("6. Enter customer purchases: ");
		int purchases = input.nextInt();	
		newCustomer.setPurchases(purchases);
		
		newCustomer.calcDiscountLvl();
		
		System.out.println("\n\nCustomer Name: "+newCustomer.getName());
		System.out.println("Customer Address: "+newCustomer.getAddress());
		System.out.println("Customer Phone Number: "+newCustomer.getNumber());
		System.out.println("Customer Number: "+newCustomer.getCNumber());
		System.out.println("Mailing List Status: "+newCustomer.getMailList());
		System.out.println("\nPurchase Amount: "+newCustomer.getPurchases());
		System.out.println("Discount Level: "+newCustomer.getDiscountLvl());
		
		double calcAmt = newCustomer.getPurchases()-(newCustomer.getPurchases()*newCustomer.getDiscountLvl());
		
		System.out.println("Calculated Purchase with Discount: "+calcAmt);
		
	} // end main
} // end class

class Person { // superclass
	// define properties
	public String _name;
	public String _address;
	public String _number;
	
	// constructor
	public Person(String name, String address, String number) {
		_name = name;
		_address = address;
		_number = number;
	} // end constructor
	
	// setters
	public void setName(String name) {
		_name = name;
	}
	public void setAddress(String address) {
		_address = address;
	}
	public void setNumber(String number) {
		_number = number;
	}
	
	// getters
	public String getName() {
		return _name;
	}
	public String getAddress() {
		return _address;
	}
	public String getNumber() {
		return _number;
	}
	
} // end class

class Customer extends Person {
	// define properties
	public String _cNumber;
	public boolean _mailList;
	
	// constructor
	public Customer(String name, String address, String number) {
		super(name, address, number);
	} // end constructor
	
	// setters
	public void setCNumber(String cNumber) {
		_cNumber = cNumber;
	}
	public void setMailList(boolean mailList) {
		_mailList = mailList;
	}

	// getters
	public String getCNumber() {
		return _cNumber;
	}
	public boolean getMailList() {
		return _mailList;
	}

} // end class

class PreferredCustomer extends Customer {
	// define properties
	public int _purchases;
	public double _discountLvl;
	
	// constructor
	public PreferredCustomer(String name, String address, String number) {
		super(name, address, number);
	} // end constructor
	
	// setters
	public void setPurchases(int purchases) {
		_purchases = purchases;
	}
	public void setDiscountLvl(double discountLvl) {
		_discountLvl = discountLvl;
	}

	// getters
	public int getPurchases() {
		return _purchases;
	}
	public double getDiscountLvl() {
		return _discountLvl;
	}
	
	// calcDiscountLvl method
	public void calcDiscountLvl() {
		if (_purchases <= 500) {
			_discountLvl = .05;
		}
		else if (_purchases <= 1000) {
			_discountLvl = .06;
		}
		else if (_purchases <= 1500) {
			_discountLvl = .07;
		}
		else {
			_discountLvl = .10;
		}
	} // end calcDiscountLvl
	
} // end class