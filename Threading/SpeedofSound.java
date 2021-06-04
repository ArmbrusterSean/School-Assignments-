public class SpeedOfSound {

	public static void main(String args[]) {
		Speed R1 = new Speed( "Air");
		Speed R2 = new Speed( "Water");
		R1.start();
		R2.start();
	}   
}


class Speed extends Thread {  // Here we extended Thread class

	private Thread t;
	private String threadName;

	public Speed( String name) {
		threadName = name;
		System.out.println("Creating " +  threadName );
	}

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
		System.out.println("Running " +  threadName );
		double time = 0.00;

		//try {
		for(double distance = 1000.00; distance <= 1010.00; distance++) {
			//System.out.print(threadName + " at " + distance + " meters");

			if (threadName.equals("Air")){
				time = distance/1100;
				System.out.printf(threadName + " at %.0f meters is %.5f \n", distance, time);
			}
			else {   // water
				time = distance/4900;
				System.out.printf(threadName + " at %.0f meters is %.5f \n", distance, time);
			}
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


} // end class Demo

