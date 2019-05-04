package Presentation;

import Logic.DTO.User;
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
        String userName = request.getParameter("user");
        String password = request.getParameter("password").toLowerCase();
        HttpSession session = request.getSession();
        User user = null;

        try
        {
            user = Logic.LogicFacade.fetchUser(userName);

            // if no user was found it could be a collective gift...but password has top be checked
        } catch (LoginSampleException ex)
        {
            user = Logic.LogicFacade.fetchUser(1); // user # 1 is "collective" user
        }
        
        if (!user.getUserPassword().equals(password))
        {
            throw new LoginSampleException("Kodeordet er forkert (id:1)");
        }
        session.setAttribute("user", user);
        session.setAttribute("giver", userName);
        session.setAttribute("wishes", Logic.LogicFacade.fetchWishes());
        return "seewishpage";
    }
}
