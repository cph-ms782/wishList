package Presentation;

import Logic.DTO.User;
import Logic.DTO.Wish;
import Logic.Exceptions.LoginSampleException;
import Logic.Exceptions.WishSampleException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * handling a new order command from request
 *
 * @author martin bøgh
 */
public class MakingNewWishCommand extends Command
{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, WishSampleException
    {

        HttpSession session = request.getSession();
        try
        {
            User user = (User) session.getAttribute("user");

//          check if the user is logged ind
            if (user!=null)
            {
                    return "newwishpage";
            } else
            {// if you're logged out (aka there's no User in session) then this message
                throw new LoginSampleException("Du er logget ud. Log ind for at fortsætte (id:2)");
            }
        } catch (NullPointerException ex)
        {
            throw new LoginSampleException("Du er logget ud. Log ind for at fortsætte (id:1)");

        }
    }

}
