public class WrongArgumentException extends RuntimeException {
    public WrongArgumentException(String message) {
        // Here, you will call Exception's constructor with message argument.
        super(message);
    }
}
