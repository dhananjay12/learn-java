package mynotes.shortConcepts;

public class JvmShutDownHookThread extends Thread{
	
	 @Override
	public void run() {
		System.out.println("JvmShutDownHookThread called");
	}

}
