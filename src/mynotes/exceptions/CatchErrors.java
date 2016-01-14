package mynotes.exceptions;

import java.io.IOError;

public class CatchErrors {
	
	private void catchErrors(){
		throw new IOError(new Throwable ("IOError"));
	}
	
	public static void main(String[] args) {
		CatchErrors aCatchErrors=new CatchErrors();
		try{
		aCatchErrors.catchErrors();
		}catch(IOError e){
			System.out.println(e.getMessage());
		}
		
		System.out.println("After");
	}

}
