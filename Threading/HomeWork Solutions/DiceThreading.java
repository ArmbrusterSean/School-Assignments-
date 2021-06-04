public class DiceThreading {

	public static void main(String args[]) {
		DiceGame player = new DiceGame( "Player");
		DiceGame computer = new DiceGame( "Computer");
		
		player.start();
		computer.start();
	
		compareRolls(player.returnRolls(), computer.returnRolls());

	}  // end main 
	
	public static void compareRolls(int[] playerR,int[] computerR) {
		int playerWins = 0;
		int playerLosses = 0;
		int playerTies = 0;
		
		for(int i = 0; i <= 999; i++) {
			if (playerR[i] > computerR[i]) {
				playerWins++;
			}
			else if (playerR[i] < computerR[i]) {
				playerLosses++;
			}
			else if (playerR[i] == computerR[i]) {
				playerTies++;
			}
		} // end for
		
		System.out.println("Player wins: "+playerWins);
		System.out.println("Computer wins: "+playerLosses);
		System.out.println("Ties: "+playerTies);
		
	}  // end compare Rolls
	
} // end class


class DiceGame extends Thread {  // Here we extended Thread class

	private Thread t;
	private String threadName;
	private int[] rolls = new int[1000];

	public DiceGame(String name) {
		threadName = name;
		System.out.println("Creating " +  threadName );
	} // end constructor

	// Starts the thread in a separate path of execution, then invokes the run() method on this Thread object.
	public void start () {
		System.out.println("Starting " +  threadName );
		if (t == null) {
			t = new Thread (this, threadName);
			t.start();
			try {
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	} // end start

	public void run() {
		System.out.println("Running " +  threadName );

		//try {
		for(int i = 0; i <= 999; i++) {
			rolls[i] = (int)Math.ceil(Math.random()*6);
			System.out.println(threadName + " rolled a " + rolls[i] + "! ");		
			
			// Let the thread sleep for a while.
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		} // end for

		System.out.println("Thread " +  threadName + " exiting.");	
		
	} // end run
	
	public int[] returnRolls() {
		try {
			this.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rolls;
	} // end returnRolls


} // end class