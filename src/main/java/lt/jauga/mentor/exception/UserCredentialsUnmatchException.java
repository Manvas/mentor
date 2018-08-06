package lt.jauga.mentor.exception;

public class UserCredentialsUnmatchException extends Exception {

    private static final long serialVersionUID = 1L;

    public UserCredentialsUnmatchException(String message) {
        super(message);
    }
}
