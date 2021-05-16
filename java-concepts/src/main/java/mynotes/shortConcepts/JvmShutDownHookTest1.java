package mynotes.shortConcepts;

public class JvmShutDownHookTest1 {

	public static void main(String[] args) {
		JvmShutDownHookThread jvmShutDownHookThread=new JvmShutDownHookThread();
		Runtime.getRuntime().addShutdownHook(jvmShutDownHookThread);
		System.out.println("Before Exit");
		System.exit(0);
		System.out.println("After Exit");
	}
	
	

}
