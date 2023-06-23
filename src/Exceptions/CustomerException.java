package Exceptions;

public class CustomerException extends Exception{
    public CustomerException() {
        super("customer not found");
    }
}
