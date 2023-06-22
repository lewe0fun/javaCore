package Exceptions;

public class CustomerException extends Exception{
    public CustomerException(String no_customer) {
        super(no_customer);
    }
}
