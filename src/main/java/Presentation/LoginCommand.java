package Presentation;

import Logic.Exceptions.LoginSampleException;
import Logic.Exceptions.WishSampleException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * command that handles login
 *
 * @author martin
 */
public class LoginCommand extends Command
{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, WishSampleException
    {
        String user = request.getParameter("user");
        String password = request.getParameter("password").toLowerCase();
        int userID =0;
        try{
            Logic.LogicFacade.
            HttpSession session = request.getSession();
            if("migselv".equals(giver)){
                user=1;
            }
            session.setAttribute("user", user);
            session.setAttribute("password", password);
            if (user==1)
            {
                return "newwishpage";
            } else
            {
                session.setAttribute("wishes", Logic.LogicFacade.fetchWishes());
                return "seewishpage";
            }
        } catch (LoginSampleException ex)
        {
            throw new LoginSampleException(("Kodeord eller brugernavn er ikke fundet"));
        }
    }
}
