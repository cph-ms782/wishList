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
public class NewWishCommand extends Command
{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, WishSampleException
    {
        
        String wishText = request.getParameter("wishtext");

        HttpSession session = request.getSession();
        String user = (String) session.getAttribute("user");
        String password = (String) session.getAttribute("password");

//          check if the user is logged ind
        if (user != null && "migselv".equals(user) && "halvtreds".equals(password))
        {
            if (wishText != null && !wishText.isEmpty())
            {
                Logic.LogicFacade.createWish(new Wish(wishText));
                session.setAttribute("wishes", Logic.LogicFacade.fetchWishes());
            } else
            {
                return "newwishpage";
            }
        } else
        {// if you're logged out (aka there's no User in session) then this message
            throw new LoginSampleException("Du er logget ud. Log ind for at fortsætte");
        }

//      if there were no exceptions sprung show the orderpage
        return "seewishpage";
    }

}
