package Presentation;

import Logic.DTO.User;
import Logic.DTO.Wish;
import Logic.Exceptions.LoginSampleException;
import Logic.Exceptions.WishSampleException;
import Logic.LogicFacade;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author martin bøgh
 */
public class ChangedWishCommand extends Command
{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, WishSampleException
    {
        String giver = request.getParameter("giver");
        String notes = request.getParameter("notes");
        String wishText = request.getParameter("wishtext");
        String link = request.getParameter("link");
        String deleted = request.getParameter("deleted");
        
        HttpSession session = request.getSession();
        try
        {
            User receiver = (User) session.getAttribute("receiver");
            User user = (User) session.getAttribute("user");
            Wish wish = (Wish) session.getAttribute("wish");

            if (wish != null)
            {

//            Change wish
                if (giver != null)
                {
                    wish.setGiver(giver);
                }

                if (notes != null)
                {
                    wish.setNotes(notes);
                }

                if (wishText != null)
                {
                    wish.setWishText(wishText);
                }

                if (link != null)
                {
                    wish.setLink(link);
                }

                if (deleted != null && deleted.equals("true"))
                {
                    session.setAttribute("wish", null);
                    LogicFacade.removeWish(wish.getWishID());
                } else
                {
                    LogicFacade.alterWish(wish);
                }
            }
            session.setAttribute("wishes", LogicFacade.fetchUserWishes(receiver.getUserID()));
            return "seewishpage";

        } catch (NullPointerException ex)
        {
            throw new LoginSampleException("Du er logget ud (id:cedwc1)");
        } catch (NumberFormatException ex)
        {
            throw new LoginSampleException("Der skal indtastes et tal (id:cedwc12)");
        }
    }
}
