package Exceptions;

public class WrongNumberOfArgumentsException extends  Exception{
    public WrongNumberOfArgumentsException() {
        super("wrong arguments amount");
    }
}
