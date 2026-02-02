package uz.uzumtech.core.exception;

import org.springframework.http.HttpStatus;
import uz.uzumtech.core.constant.enums.ErrorType;

public class IngredientNotFoundException extends ApplicationException{
    public IngredientNotFoundException(String message) {
        super(10011, message, HttpStatus.NOT_FOUND, ErrorType.INTERNAL);
    }
}
