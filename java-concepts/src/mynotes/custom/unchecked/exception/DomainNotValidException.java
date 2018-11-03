package mynotes.custom.unchecked.exception;

public class DomainNotValidException extends RuntimeException {

    public DomainNotValidException(String message) {
        super(message);
    }
}
