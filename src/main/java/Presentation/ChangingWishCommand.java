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
public class ChangingWishCommand extends Command
{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, WishSampleException
    {
        HttpSession session = request.getSession();
        try
        {
            User user = (User) session.getAttribute("user");
            User receiver = (User) session.getAttribute("receiver");
            int wishID = Integer.parseInt(request.getParameter("wishID"));
            if (user != null && receiver != null && wishID > 0)
            {
                session.setAttribute("wish", Logic.LogicFacade.fetchWish(wishID));

                //user is the same as receiver and not the collective user
                if (user.getUserID() == receiver.getUserID() && user.getUserID() > 1)
                {
                    return "changewishownerpage";
                }
                return "changewishpage";
            } else
            {// if you're logged out (aka there's no User in session) then this message
                throw new LoginSampleException("Du er logget ud. Log ind for at fortsætte (id:ciwc1");
            }
        } catch (NumberFormatException e)
        {
            return "seewishpage";
        }
    }
}
