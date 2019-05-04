package Data;

import Logic.DTO.Wish;
import Logic.Exceptions.LoginSampleException;
import Logic.Exceptions.WishSampleException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 * @author
 */
public class WishMapper_DB
{

    static Connection con;
    static ResultSet rs;
    static PreparedStatement ps;

    public static Wish createWish(Wish wish) throws WishSampleException, LoginSampleException
    {
        try
        {
            con = Connector.connection(con);
            String SQL = "INSERT INTO `wishes` (`wishtext`, `giver`, `notes`, `link`, `userid`) VALUES (?, ?, ?, ?, ?)";
            ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, wish.getWishText());
            ps.setString(2, wish.getGiver());
            ps.setString(3, wish.getNotes());
            ps.setString(4, wish.getLink());
            ps.setInt(5, wish.getUserID());
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            rs.next();
            return getWish(wish.getWishText());
        } catch (SQLException ex)
        {
            throw new WishSampleException("Kunne ikke skabe nyt ønske: " + ex.getMessage());
        } finally
        {
            Connector.CloseConnection(rs, ps, con);
        }
    }

    /**
     *
     * @param id
     * @return
     * @throws LoginSampleException
     * @throws WishSampleException
     */
    public static boolean removeWish(int id) throws LoginSampleException, WishSampleException
    {
        try
        {
            con = Connector.connection(con);
            String SQL = "DELETE FROM `wishes` WHERE `id` = ?";
            ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            rs.next();
            return true;
        } catch (SQLException ex)
        {
            throw new WishSampleException("Kunne ikke slette ønske: " + ex.getMessage());
        } finally
        {
            Connector.CloseConnection(rs, ps, con);
        }
    }

    /**
     *
     * @param wish
     * @return
     * @throws WishSampleException
     * @throws LoginSampleException
     */
    public static Wish alterWish(Wish wish) throws WishSampleException, LoginSampleException
    {
        try
        {
            con = Connector.connection(con);

            String SQL = "UPDATE `wishes` SET wishtext =?, giver= ?, notes=?, `link`=? WHERE id = ?;";
            ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, wish.getWishText());
            ps.setString(2, wish.getGiver());
            ps.setString(3, wish.getNotes());
            ps.setString(4, wish.getLink());
            ps.setInt(5, wish.getWishID());
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            rs.next();
            return wish;
        } catch (SQLException ex)
        {
            throw new WishSampleException("Kunne ikke ændre ønske: " + ex.getMessage());
        } finally
        {
            Connector.CloseConnection(rs, ps, con);
        }
    }

    /**
     *
     * @param id
     * @return
     * @throws WishSampleException
     * @throws LoginSampleException
     */
    public static Wish getWish(int id) throws WishSampleException, LoginSampleException
    {
        String wishtext = null;
        String giver = null;
        String notes = null;
        String link = null;
        int userID = 0;

        try
        {
            con = Connector.connection(con);

            String SQL = "SELECT * FROM `wishes` WHERE id = ?;";
            ps = con.prepareStatement(SQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next())
            {
                wishtext = rs.getString("wishtext");
                giver = rs.getString("giver");
                notes = rs.getString("notes");
                link = rs.getString("link");
                userID = rs.getInt("userid");
            }
            return new Wish(id, wishtext, giver, notes, link, userID);

        } catch (SQLException ex)
        {
            throw new WishSampleException("Kunne ikke skabe nyt ønske: " + ex.getMessage());
        } finally
        {
            Connector.CloseConnection(rs, ps, con);
        }
    }

    /**
     *
     * @param wishText
     * @return
     * @throws WishSampleException
     * @throws LoginSampleException
     */
    public static Wish getWish(String wishText) throws WishSampleException, LoginSampleException
    {
        int wishID = 0;
        String giver = null;
        String notes = null;
        String link = null;
        int userID = 0;

        try
        {
            con = Connector.connection(con);

            String SQL = "SELECT * FROM `wishes` WHERE wishtext = ?;";
            ps = con.prepareStatement(SQL);
            ps.setString(1, wishText);
            rs = ps.executeQuery();
            while (rs.next())
            {
                wishID = rs.getInt("id");
                giver = rs.getString("giver");
                notes = rs.getString("notes");
                link = rs.getString("link");
                userID = rs.getInt("userid");
            }
            return new Wish(wishID, wishText, giver, notes, link, userID);

        } catch (SQLException ex)
        {
            throw new WishSampleException("Kunne ikke skabe nyt ønske: " + ex.getMessage());
        } finally
        {
            Connector.CloseConnection(rs, ps, con);
        }
    }

    public static List<Wish> getWishes() throws WishSampleException, LoginSampleException
    {
        List<Wish> wishes = new ArrayList();
        try
        {
            con = Connector.connection(con);

            String SQL = "SELECT * FROM `wishes`;";
            ps = con.prepareStatement(SQL);
            rs = ps.executeQuery();
            while (rs.next())
            {
                wishes.add(new Wish(rs.getInt("id"),
                        rs.getString("wishtext"),
                        rs.getString("giver"),
                        rs.getString("notes"),
                        rs.getString("link"),
                        rs.getInt("userid")
                ));
            }
            return wishes;

        } catch (SQLException ex)
        {
            throw new WishSampleException("Kunne ikke skabe liste med ønsker: " + ex.getMessage());
        } finally
        {
            Connector.CloseConnection(rs, ps, con);
        }
    }
    
    public static List<Wish> getWishes(int userID) throws WishSampleException, LoginSampleException
    {
        List<Wish> wishes = new ArrayList();
        try
        {
            con = Connector.connection(con);

            String SQL = "SELECT * FROM `wishes` WHERE id=?;";
            ps = con.prepareStatement(SQL);
            ps.setInt(1, userID);
            rs = ps.executeQuery();
            while (rs.next())
            {
                wishes.add(new Wish(userID,
                        rs.getString("wishtext"),
                        rs.getString("giver"),
                        rs.getString("notes"),
                        rs.getString("link"),
                        rs.getInt("userid")
                ));
            }
            return wishes;

        } catch (SQLException ex)
        {
            throw new WishSampleException("Kunne ikke skabe liste med ønsker: " + ex.getMessage());
        } finally
        {
            Connector.CloseConnection(rs, ps, con);
        }
    }
}
