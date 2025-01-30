package es.amadorcf.YourBank_backend.exception;

public class UserValidation extends RuntimeException{

    public UserValidation(String message) {
        super(message);
    }
}
