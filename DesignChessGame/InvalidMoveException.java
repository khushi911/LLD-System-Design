package chessgame;
//In Java, RuntimeException is a class that serves as the superclass for those exceptions that can be thrown during the normal operation of the Java Virtual Machine. 
public class InvalidMoveException extends RuntimeException{
    public InvalidMoveException(final String message) {
        super(message);
    }
}
