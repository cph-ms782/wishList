package Data;

import Logic.DTO.Wish;
import Logic.Exceptions.LoginSampleException;
import Logic.Exceptions.WishSampleException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
            String SQL = "INSERT INTO `wishes` (wishtext, giver, notes) VALUES (?, ?, ?)";
            ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, wish.getWishText());
            ps.setString(2, wish.getGiver());
            ps.setString(3, wish.getNotes());
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            rs.next();
            int wishID = rs.getInt(1);
            wish.setWishID(wishID);
            return wish;
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

            String SQL = "UPDATE `wishes` SET wishtext =?, giver= ?, notes=? WHERE id = ?;";
            ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, wish.getWishText());
            ps.setString(2, wish.getGiver());
            ps.setString(3, wish.getNotes());
            ps.setInt(4, wish.getWishID());
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            rs.next();
            return wish;
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
     * @throws WishSampleException
     * @throws LoginSampleException
     */
    public static Wish getWish(int id) throws WishSampleException, LoginSampleException
    {
        String wishtext = null;
        String giver = null;
        String notes = null;

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
            }
            return new Wish(id, wishtext, giver, notes);
            
        } catch (SQLException ex)
        {
            throw new WishSampleException("Kunne ikke skabe nyt ønske: " + ex.getMessage());
        } finally
        {
            Connector.CloseConnection(rs, ps, con);
        }
    }

}
