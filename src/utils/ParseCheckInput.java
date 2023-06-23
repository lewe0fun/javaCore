package utils;


import Exceptions.WrongArgumentException;
import Exceptions.WrongNumberOfArgumentsException;

public class ParseCheckInput {
    public static String[] parseCheck(String source) throws WrongNumberOfArgumentsException, WrongArgumentException {
        String[] strings = source.split(" ");
        if (strings.length != 3) throw new WrongNumberOfArgumentsException();
        char[] charString = strings[0].toCharArray();
        if (!(charString[0] == '+')) throw new WrongArgumentException();
        for (int i = 1; i < charString.length - 1; i++)
            if (!Character.isDigit(charString[i])) throw new WrongArgumentException();
        charString = strings[2].toCharArray();
        for (int i = 0; i < charString.length; i++)
            if (!Character.isDigit(charString[i])) throw new WrongArgumentException();
        return strings;
    }
}
