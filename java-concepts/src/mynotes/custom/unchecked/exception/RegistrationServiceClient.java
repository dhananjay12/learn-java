package mynotes.custom.unchecked.exception;

public class RegistrationServiceClient {

    public static void main(String[] args) {
        RegistrationService service = new RegistrationService();
        service.validateEmail("abc@gmail1.com");
    }

}
