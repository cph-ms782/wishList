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
        User receiver = null;
        User user = null;
        try
        {
            user = (User) session.getAttribute("user");

            //sometimes SeeWishesCommand is called from pages where theres no param: userName
            if (userName != null && !userName.isEmpty())
            {
                receiver = LogicFacade.fetchUser(userName);
            } else
            {
                receiver = user;
            }
            if (user != null)
            {
                session.setAttribute("receiver", receiver);
                if (user.getUserID() == 1)
                {
                    String collectiveUser = user.getUserName().replace("_fælles", "");
                    session.setAttribute("wishes", Logic.LogicFacade.fetchUserWishes(LogicFacade.fetchUser(collectiveUser).getUserID()));
                } else
                {
                    session.setAttribute("wishes", Logic.LogicFacade.fetchUserWishes(user.getUserID()));
                }
            }
        } catch (LoginSampleException ex)
        {
            throw new LoginSampleException("Du er logget ud (id:swc1)");
        }
        return "seewishpage";
    }
}
