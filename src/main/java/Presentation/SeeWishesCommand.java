package Presentation;

import Logic.DTO.User;
import Logic.LogicFacade;
import Logic.Exceptions.LoginSampleException;
import Logic.Exceptions.WishSampleException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * handling a finished order command coming from the neworderpage.jsp
 *
 * @author martin bøgh
 */
public class SeeWishesCommand extends Command
{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, WishSampleException
    {
        String userName = request.getParameter("userName");
        HttpSession session = request.getSession();
        try
        {
            User receiver = LogicFacade.fetchUser(userName);
            User user = (User) session.getAttribute("user");
            if (user != null)
            {
                session.setAttribute("receiver", receiver);
                session.setAttribute("wishes", LogicFacade.fetchUserWishes(receiver.getUserID()));
            }
        } catch (LoginSampleException ex)
        {
            throw new LoginSampleException("Du er logget ud (id:swc1)");
        }
        return "seewishpage";
    }
}
