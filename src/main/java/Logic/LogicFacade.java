package Logic;

import Data.UserMapper_DB;
import Logic.Exceptions.LoginSampleException;
import Data.WishMapper_DB;
import Logic.DTO.User;
import Logic.DTO.Wish;
import Logic.Exceptions.WishSampleException;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;

/**
 * facade for handling traffic between data and presentation
 *
 * @author kasper and martin bøgh
 */
public class LogicFacade
{

    /**
     * *********** WISH *****************
     */
    public static Wish createWish(Wish wish) throws WishSampleException, LoginSampleException
    {
        return WishMapper_DB.createWish(wish);
    }

    public static boolean removeWish(int id) throws LoginSampleException, WishSampleException
    {
        return WishMapper_DB.removeWish(id);
    }

    public static Wish alterWish(Wish wish) throws WishSampleException, LoginSampleException
    {
        return WishMapper_DB.alterWish(wish);
    }

    public static Wish fetchWish(int id) throws WishSampleException, LoginSampleException
    {
        return WishMapper_DB.getWish(id);
    }

    public static List<Wish> fetchWishes() throws WishSampleException, LoginSampleException
    {
        return WishMapper_DB.getWishes();
    }

        public static List<Wish> fetchUserWishes(int userID) throws WishSampleException, LoginSampleException
    {
        List<Wish> userWishes = new ArrayList<>();
        for (Wish wish : fetchWishes())
        {
            if(wish != null && wish.getUserID() == userID){
                userWishes.add(wish);
            }
        }
        return userWishes;
    }
        
    /**
     * *********** USER *****************
     */
    public static User alterUser(User user) throws WishSampleException, LoginSampleException
    {
        return UserMapper_DB.alterUser(user);
    }

    public static User fetchUser(int id) throws WishSampleException, LoginSampleException
    {
        return UserMapper_DB.getUser(id);
    }

    public static User fetchUser(String userName) throws WishSampleException, LoginSampleException
    {
        return UserMapper_DB.getUser(userName);
    }
    
    public static List<User> fetchUsers() throws WishSampleException, LoginSampleException
    {
        return UserMapper_DB.getUsers();
    }

    
    /**
     * *********** TEST *****************
     */
    public static void main(String[] args) throws WishSampleException, LoginSampleException
    {
//        Wish wish = new Wish("Keyboard", "Lars", "Den køber vi");
//        Wish wish = new Wish("Keyboard");
//        System.out.println(createWish(wish).toString());
//        System.out.println(removeWish(12));
//        wish = fetchWish(5);
//        System.out.println("fetch: " + wish);
//        wish = new Wish(wish. getWishID(), "Musealter", "Lars og Hans", "Fandt den billigt");
//        System.out.println("alter: " + alterWish(wish));
//        for (Wish wish : fetchWishes())
//        {
//            System.out.println(wish.toString());
//        }
//        for (User user : fetchUsers())
//        {
//            System.out.println(user.toString());
//        }
            System.out.println(fetchUser("Martin"));
            System.out.println(fetchUser(4));

    }

}
