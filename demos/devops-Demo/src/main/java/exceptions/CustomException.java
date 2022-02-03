package exceptions;

import javax.servlet.ServletException;

public class CustomException extends ServletException {
    public CustomException(String message) {
        super(message);
        //comment!
    }
}
