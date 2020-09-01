package Utils;

public class DriverNotFoundException extends RuntimeException {
    DriverNotFoundException(String message) {
        super(message);
    }
}
