package Presentation;

import Logic.DTO.User;
import Logic.Exceptions.LoginSampleException;
import Logic.Exceptions.WishSampleException;
import Logic.LogicFacade;
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
            session.setAttribute("giver", userName);

            // if no user was found it could be a collective gift...but password has to be checked
        } catch (LoginSampleException ex)
        {
            throw new LoginSampleException("Der er sket en fejl. Er kodeordet skrevet korrekt? (id:lc1)");

        }

        if (user == null || !user.getUserPassword().equals(password))
        {
            throw new LoginSampleException("Der er gået noget galt (er kodeordet er forkert (id:1)");
        }
        session.setAttribute("user", user);
        session.setAttribute("receiver", user);
        if (user.getUserID() == 1)
        {
            String collectiveUser = user.getUserName().replace("_fælles", "");
            session.setAttribute("wishes", Logic.LogicFacade.fetchUserWishes(LogicFacade.fetchUser(collectiveUser).getUserID()));
        } else
        {
            session.setAttribute("wishes", Logic.LogicFacade.fetchUserWishes(user.getUserID()));
        }
        return "seewishpage";
    }
}
