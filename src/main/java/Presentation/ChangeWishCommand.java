package Presentation;

import Logic.DTO.User;
import Logic.Exceptions.LoginSampleException;
import Logic.Exceptions.WishSampleException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author martin bøgh
 */
public class ChangeWishCommand extends Command
{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, WishSampleException
    {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String password = (String) session.getAttribute("password");
        try
        {
//          check if the user is logged ind
            if ("halvtreds".equals(password) || user!=null && user.getUserID()!= 0)
            {
                session.setAttribute("wish", Logic.LogicFacade.fetchWish(id));
                if ((user != null && user.getUserID() > 0))
                {
                    return "changewishownerpage";
                }
                return "changewishpage";
            } else
            {// if you're logged out (aka there's no User in session) then this message
                throw new LoginSampleException("Du er logget ud. Log ind for at fortsætte");
            }
        } catch (NumberFormatException e)
        {
            return "seewishpage";
        }
    }
}
