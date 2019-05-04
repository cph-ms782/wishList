package Data;

import static Data.UserMapper_DB.con;
import Logic.DTO.User;
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
public class UserMapper_DB 
{

    static Connection con;
    static ResultSet rs;
    static PreparedStatement ps;

    public static User getUser(int userID) throws WishSampleException
    {
        String userName = null;
        String password = null;
        String img = null;

        try
        {
            con = Connector.connection(con);

            String SQL = "SELECT * FROM `user` WHERE userid = ?;";
            ps = con.prepareStatement(SQL);
            ps.setInt(1, userID);
            rs = ps.executeQuery();
            while (rs.next())
            {
                userName = rs.getString("username");
                password = rs.getString("password");
                img = rs.getString("img");
            }
            return new User(userID, userName, password, img);

        } catch (SQLException | LoginSampleException ex)
        {
            throw new WishSampleException("Kunne ikke finde bruger: " + ex.getMessage());
        } finally
        {
            Connector.CloseConnection(rs, ps, con);
        }
    }
    
    public static User getUser(String userName) throws WishSampleException
    {
        
        int userID=0;
        String password = null;
        String img = null;

        try
        {
            con = Connector.connection(con);

            String SQL = "SELECT * FROM `user` WHERE user = ?;";
            ps = con.prepareStatement(SQL);
            ps.setInt(1, userID);
            rs = ps.executeQuery();
            while (rs.next())
            {
                userID = rs.getInt("userid");
                password = rs.getString("password");
                img = rs.getString("img");
            }
            return new User(userID, userName, password, img);

        } catch (SQLException | LoginSampleException ex)
        {
            throw new WishSampleException("Kunne ikke finde bruger: " + ex.getMessage());
        } finally
        {
            Connector.CloseConnection(rs, ps, con);
        }
    }

    public static User changePassword(int userID, String password) throws WishSampleException
    {
        try
        {
            con = Connector.connection(con);

            String SQL = "UPDATE `user` SET password=? WHERE userid = ?;";
            ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, password);
            ps.setInt(2, userID);
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            rs.next();
            return getUser(userID);
        } catch (SQLException | LoginSampleException ex)
        {
            throw new WishSampleException("Kunne ikke ændre brugers kodeord: " + ex.getMessage());
        } finally
        {
            Connector.CloseConnection(rs, ps, con);
        }
    }
}
