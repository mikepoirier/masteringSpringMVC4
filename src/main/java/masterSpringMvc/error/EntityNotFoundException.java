package masterSpringMvc.error;

/**
 * Created by blindweasel on 9/29/15.
 */
public class EntityNotFoundException extends Exception
{
    public EntityNotFoundException(String message)
    {
        super(message);
    }

    public EntityNotFoundException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
