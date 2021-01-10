package themain;

import karlson.Man;

public class HumanDoesNotExistException extends Exception{
    public HumanDoesNotExistException() {
    }

    public HumanDoesNotExistException(String message) {
        super(message);
    }

    public HumanDoesNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public HumanDoesNotExistException(Throwable cause) {
        super(cause);
    }

    public HumanDoesNotExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
