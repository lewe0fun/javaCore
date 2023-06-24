package Exceptions;

public class TooMuchSaleException extends Exception{
    public TooMuchSaleException() {
        super("not for premium");
    }
}
