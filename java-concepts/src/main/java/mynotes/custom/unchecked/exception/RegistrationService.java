package mynotes.custom.unchecked.exception;

import java.util.Arrays;
import java.util.List;

public class RegistrationService {

    public void validateEmail(String email) {
        if (!isDomainValid(email)) {
            throw new DomainNotValidException("Invalid domain");
        }
    }

    private boolean isDomainValid(String email) {
        List<String> validDomains = Arrays.asList("gmail.com", "yahoo.com", "outlook.com");
        if (validDomains.contains(email.substring(email.indexOf("@") + 1))) {
            return true;
        }
        return false;
    }

}
