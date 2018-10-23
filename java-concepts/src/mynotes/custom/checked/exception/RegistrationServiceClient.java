package mynotes.custom.checked.exception;

public class RegistrationServiceClient {

	public static void main(String[] args) {
		RegistrationService service = new RegistrationService();

		try {
			service.validateEmail("abc@gmail.com");
		} catch (EmailNotUniqueException e) {
			e.printStackTrace();
		}
	}

}
