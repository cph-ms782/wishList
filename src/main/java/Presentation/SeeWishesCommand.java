package Presentation;

import Logic.LogicFacade;
import Logic.DTO.Wish;
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
        String giver = request.getParameter("giver");
        String notes = request.getParameter("notes");
        String wishText = request.getParameter("wishtext");
        int id = Integer.parseInt(request.getParameter("index"));

        HttpSession session = request.getSession();
        String password = (String) session.getAttribute("password");

        if ("halvtreds".equals(password))
        {
//            Change wish
            Wish w = LogicFacade.fetchWish(id);

            if (giver != null)
            {
                w.setGiver(giver);
            }

            if (notes != null)
            {
                w.setNotes(notes);
            }
            
            if (wishText != null)
            {
                w.setWishText(wishText);
            }
            
            LogicFacade.alterWish(w);
            session.setAttribute("wishes", LogicFacade.fetchWishes());
            return "seewishpage";
        }
        return "loginpage";
    }
}
