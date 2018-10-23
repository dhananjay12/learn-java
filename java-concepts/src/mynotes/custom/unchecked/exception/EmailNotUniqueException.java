package mynotes.custom.unchecked.exception;

public class EmailNotUniqueException extends RuntimeException {
	
	public EmailNotUniqueException(String message) {
		super(message);
	}
}
