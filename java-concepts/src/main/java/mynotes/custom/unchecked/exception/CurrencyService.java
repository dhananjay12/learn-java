package mynotes.custom.unchecked.exception;

public class CurrencyService {

	public String convertDollarsToEuros(String value) {

		try {
			int x = Integer.parseInt(value);
		} catch (NumberFormatException e) {
			throw new InvalidCurrencyDataException("Invalid data", e, ErrorCodes.VALIDATION_PARSE_ERROR);
		}

		return value;
	}

}
