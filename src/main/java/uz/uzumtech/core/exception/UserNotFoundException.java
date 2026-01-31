package uz.uzumtech.core.exception;

import org.springframework.http.HttpStatus;
import uz.uzumtech.core.constant.enums.ErrorType;

public class UserNotFoundException extends ApplicationException{
    public UserNotFoundException(String message) {
        super(10011, message, HttpStatus.NOT_FOUND, ErrorType.INTERNAL);
    }
}
