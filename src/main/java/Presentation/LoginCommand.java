package Presentation;

import Logic.Exceptions.LoginSampleException;
import Logic.Exceptions.WishSampleException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * command that handles login
 *
 * @author kasper
 */
public class LoginCommand extends Command
{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, WishSampleException
    {
        String giver = request.getParameter("giver");
        String password = request.getParameter("password");
        if ("halvtreds".equals(password))
        {
            HttpSession session = request.getSession();
            if ("migselv".equals(giver))
            {
                session.setAttribute("user", giver);
                return "newwishpage";
            } else
            {
                session.setAttribute("user", giver);
                session.setAttribute("wishes", Logic.LogicFacade.fetchWishes());
                return "seewishpage";
            }
        }
        return "loginpage";
    }
}
