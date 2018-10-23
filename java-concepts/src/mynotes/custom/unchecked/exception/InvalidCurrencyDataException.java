package mynotes.custom.unchecked.exception;

public class InvalidCurrencyDataException extends RuntimeException {
	
	private Integer errorCode;
	
	public InvalidCurrencyDataException(String message) {
		super(message);
	}
	
	public InvalidCurrencyDataException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public InvalidCurrencyDataException(String message, Throwable cause, ErrorCodes errorCode) {
		super(message, cause);
		this.errorCode = errorCode.getCode();
	}
	
	public Integer getErrorCode() {
		return errorCode;
	}
}