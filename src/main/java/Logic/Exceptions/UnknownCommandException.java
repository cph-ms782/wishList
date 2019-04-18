package Logic.Exceptions;

/**
 *  Error thrown when there's now Command to handle request
 * 
 * @author martin
 */
public class UnknownCommandException extends Exception
{

    /**
     * Only one place for this error message, so hardcoding it into method.
     *
     * @param msg the detail message.
     */
    public UnknownCommandException()
    {
        super("Husk at man kan logge ud ved at trykke på 50 skiltet");
    }
}
