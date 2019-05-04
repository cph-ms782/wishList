package Data;

import Logic.DTO.User;
import Logic.Exceptions.WishSampleException;

/**
 *
 * @author martin
 */
public interface UserMapper
{
    User getUser(int userID) throws WishSampleException;
    User getUser(String username) throws WishSampleException;
    User changePassword(int userID, String password) throws WishSampleException;
}
