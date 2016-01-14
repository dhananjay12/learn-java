package mynotes.shortConcepts;

public class JvmShutDownHookTest2 {

	public static void main(String[] args) {
		System.out.println("Main start");
		JvmShutDownHookThread jvmShutDownHookThread=new JvmShutDownHookThread();
		Runtime.getRuntime().addShutdownHook(jvmShutDownHookThread);
		System.out.println("Main end");
	}	

}
