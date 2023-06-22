package Exceptions;

public class AmountException extends Exception{
    public AmountException(String tooMatch) {
        super(tooMatch);
    }
}
