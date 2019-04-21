package Presentation;

import Logic.DTO.Wish;
import Logic.Exceptions.LoginSampleException;
import Logic.Exceptions.WishSampleException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * handling a new order command from request
 *
 * @author martin bøgh
 */
public class DeleteWishCommand extends Command
{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, WishSampleException
    {
        HttpSession session = request.getSession();
        String user = (String) session.getAttribute("user");
        String password = (String) session.getAttribute("password");
        try
        {
            int id = Integer.parseInt(request.getParameter("index"));

//          check if the user is logged ind
            if (id != 0 && "halvtreds".equals(password))
            {
                session.setAttribute("wish", null);
                Logic.LogicFacade.removeWish(id);
                session.setAttribute("wishes", Logic.LogicFacade.fetchWishes());
                
                return "seewishpage";
            } else
            {// if you're logged out (aka there's no User in session) then this message
                throw new LoginSampleException("Du er logget ud. Log ind for at fortsætte");
            }
        } catch (NumberFormatException e)
        {
            return "seewishpage";
        }
    }
}
