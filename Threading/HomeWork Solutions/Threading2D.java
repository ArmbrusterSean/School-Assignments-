import java.util.Random;

public class Threading2D {
	public static void main(String args[]) {	//This is the driver 
		Contestant D1 = new Contestant( "Computer");
		Contestant D2 = new Contestant( "Human");
		D1.start();
		D2.start();
	}   
}//end class


class Contestant extends Thread {  // Here we extended Thread class
	//fields
	private Thread t;
	private String threadName;
	public static int[][] rollRecord=new int[2][1000];//hold roll values. Human in C0, Comp in C1. Possibly questionable use of a global variable.
	
	public Contestant (String name) {
		threadName = name;
		System.out.println("Creating " +  threadName );
	}//end Speed: This looks purely esthetic.
	
	// Starts the thread in a separate path of execution, then invokes the run() method on this Thread object.
	public void start () {
		System.out.println("Starting " +  threadName );
		if (t == null) {
			t = new Thread (this, threadName);
			t.start ();
		}
	} // end start

	// If this Thread object was instantiated using a separate Runnable target, 
	// the run() method is invoked on that Runnable object.
	public void run() {
		System.out.println("Rolling " +  threadName );
		
		//try {
		for(int roll = 1; roll <= 1000.00; roll++) {
			if (threadName.equals("Human")){
				int dieValue=dieValue();
				System.out.println(threadName + " on roll "+roll+" rolled a "+dieValue);
				rollRecord(0,dieValue,roll);
			}
			
			else {   // computer
				int dieValue=dieValue();
				System.out.println(threadName + " on roll "+roll+" rolled a "+dieValue);
				rollRecord(1,dieValue,roll);
			}
			
			// Let the thread sleep for a while.
			try {
				Thread.sleep(0);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} // end for
		System.out.println("Thread " +  threadName + " exiting.");
		compare();		
	} // end run
	
	
	/*  My added method */

	//recordResults: recorded into a 2D array.
	public void rollRecord(int inCategory, int inRollValue, int inRollNumber){
		int category=inCategory;
		int rollValue=inRollValue;
		int rollNumber=inRollNumber-1;
		rollRecord[category][rollNumber]=rollValue;
	}
	
	///Random die value method
	public int dieValue() {
		Random rand = new Random(); 
		int dieValue = rand.nextInt(6)+1;
		return dieValue;
	}//end dieValue

	//compares the stored values
	private void compare() {
		if(rollRecord[0][999] != 0 && rollRecord[1][999] != 0) { //triggers only once both collumns are filled.
			int ties=0;
			int humWins=0;
			int compWins=0;
			
			for(int row = 0; row < 1000; row++) {
				if (rollRecord[0][row]==rollRecord[1][row]) {
					ties++;
				}//end if
				else if (rollRecord[0][row]>rollRecord[1][row]) {
					humWins++;
				}//end else if
				else{
					compWins++;
				}//end else				
			}//end for
			System.out.println("The human and computer tied "+ties+" times.");
			System.out.println("The human won "+humWins+" times.");
			System.out.println("The computer won "+compWins+" times.");
		}//end if
	}//end compare
	
}// end Thread class