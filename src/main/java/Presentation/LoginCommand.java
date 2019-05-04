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
            //first letter Uppercase
            user = Logic.LogicFacade.fetchUser(userName.substring(0, 1).toUpperCase() + userName.substring(1).toLowerCase());

            // if no user was found it could be a collective gift...but password has to be checked
        } catch (LoginSampleException ex)
        {
            user = Logic.LogicFacade.fetchUser(1); // user # 1 is "collective" user
            session.setAttribute("giver", userName);

        }

        if (user == null || !user.getUserPassword().equals(password))
        {
            throw new LoginSampleException("Der er gået noget galt (er kodeordet er forkert (id:1)");
        }
        session.setAttribute("user", user);
        session.setAttribute("receiver", user);
        session.setAttribute("wishes", Logic.LogicFacade.fetchUserWishes(user.getUserID()));
        return "seewishpage";
    }
}
