package mynotes.concurrency.basic;

public class DeadLockExample {

	public static void main(String[] args){
	    //These are the two resource objects we'll try to get locks for
	    final Object resource1 = "resource1";
	    final Object resource2 = "resource2";
	    //Here's the first thread. It tries to lock resource1 then resource2
	    Thread t1 = new Thread() {
	      public void run() {
	        //Lock resource 1
	        synchronized(resource1){
	          System.out.println("Thread 1: locked resource 1");
	       try{ 
	            Thread.sleep(50); 
	          } catch (InterruptedException e) {}

	          //Now wait 'till we can get a lock on resource 2
	          synchronized(resource2){
	            System.out.println("Thread 1: locked resource 2");
	          }
	        }
	      }
	    };

	    //Here's the second thread. It tries to lock resource2 then resource1
	    Thread t2 = new Thread(){
	      public void run(){
	        //This thread locks resource 2 right away
	        synchronized(resource2){
	          System.out.println("Thread 2: locked resource 2");
	          //Then it pauses, for the same reason as the first thread does
	          try{
	    		Thread.sleep(50); 
	    	  } catch (InterruptedException e){}
	           synchronized(resource1){
	            System.out.println("Thread 2: locked resource 1");
	          }
	        }
	      }
	    };

	    //Start the two threads. 
	    t1.start(); 
	    t2.start();
	    
	    try {
			t1.join();
			t2.join();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	    System.out.println("Programm finished");
	  }
	}