package mynotes.concurrency.basic;

import java.util.Scanner;

public class WaitNotifyExample {

	Object myMonitorObject = new Object();
	boolean signal = false;

	public void produce() throws InterruptedException {
		synchronized (myMonitorObject) {
			System.out.println("produce method running...");
			if(!signal){
			myMonitorObject.wait();
			}
			System.out.println("produce method RESUMED...");
			signal=false;
		}
	}

	public void consumes() throws InterruptedException {
		Scanner scanner = new Scanner(System.in);

		synchronized (myMonitorObject) {
			System.out.println("consumes method running...");
			signal=true;
			scanner.nextLine();
			System.out.println("Consume method- returned key pressed");
			myMonitorObject.notify();
		}
	}

}
