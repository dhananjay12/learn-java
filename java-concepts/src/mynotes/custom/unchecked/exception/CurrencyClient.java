package mynotes.custom.unchecked.exception;

public class CurrencyClient {

	public static void main(String[] args) {

		CurrencyService service = new CurrencyService();
		service.convertDollarsToEuros("asd");

	}

}
