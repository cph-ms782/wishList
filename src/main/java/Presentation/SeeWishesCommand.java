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
    String execute(HttpServletRequest request, HttpServletResponse response) throws WishSampleException, LoginSampleException
    {
        HttpSession session = request.getSession();
        String user = (String) session.getAttribute("user");

//      check if the user is logged ind
        if (user != null && "true".equals(user))
        {
//            try
//            {
//                wish = new Wish(user.getID(), length, width, height, false);
//
//                //Save and fill order with orderID
//                order = LogicFacade.createOrder(order);
//                session.setAttribute("wishes",
//                        LogicFacade.fillOrderList(LogicFacade.fetchOrders(user.getID())));
//                session.setAttribute("order", order);
//
//            } catch (WishSampleException ex)
//            {// if there's been an error in the fetching of data from storage
//                throw new WishSampleException("Der er sket en fejl i håndteringen af det nye ønske" + ex.getMessage());
//            }

//          if there's been no exception pass on the next page
            return "seewishespage";
        }
//      if you're not logged in an a customer this message
        throw new LoginSampleException("Man skal være logget ind");
    }

}
