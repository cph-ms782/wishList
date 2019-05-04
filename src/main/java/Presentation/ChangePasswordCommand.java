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
public class ChangePasswordCommand extends Command
{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, WishSampleException
    {
        String giver = request.getParameter("giver");
        String password = request.getParameter("password").toLowerCase();
        int user =0;
        
        if ("halvtreds".equals(password))
        {
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
        }
        throw new LoginSampleException("Skriv de rigtige login detaljer for at komme ind");
    }
}
