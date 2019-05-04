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
        String giver = request.getParameter("giver").toLowerCase();
        String password = request.getParameter("password").toLowerCase();
        HttpSession session = request.getSession();
        User user = Logic.LogicFacade.fetchUser(giver);

        if (user.getUserID() != 0)
        {
            session.setAttribute("user", user);
            session.setAttribute("password", password);
            session.setAttribute("wishes", Logic.LogicFacade.fetchWishes(user.getUserID()));
            return "seewishpage";
        }

        if ("halvtreds".equals(password))
        {
            session.setAttribute("user", null);
            session.setAttribute("wishes", Logic.LogicFacade.fetchWishes());
            return "seewishpage";
        }
        throw new LoginSampleException("Skriv de rigtige login detaljer for at komme ind");
    }
}
