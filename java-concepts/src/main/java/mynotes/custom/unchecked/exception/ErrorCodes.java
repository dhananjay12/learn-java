package mynotes.custom.unchecked.exception;

public enum ErrorCodes {

	VALIDATION_PARSE_ERROR(422);

	private int code;

	ErrorCodes(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

}
