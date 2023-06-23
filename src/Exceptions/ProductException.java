package Exceptions;

public class ProductException extends Exception{
    public ProductException() {
        super("Product not found");
    }
}
