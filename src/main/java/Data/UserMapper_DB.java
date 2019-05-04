package Data;

import Logic.DTO.User;
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
public class UserMapper_DB
{

    static Connection con;
    static ResultSet rs;
    static PreparedStatement ps;

    /**
     *
     * @param user
     * @return
     * @throws LoginSampleException
     */
    public static User alterUser(User user) throws LoginSampleException
    {
        try
        {
            con = Connector.connection(con);

            String SQL = "UPDATE `user` SET `user`=?, `userpassword`= ?, `image`=? WHERE userid = ?;";
            ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getUser());
            ps.setString(2, user.getUserPassword());
            ps.setString(3, user.getImage());
            ps.setInt(4, user.getUserID());
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            rs.next();
            return getUser(user.getUserID());
        } catch (SQLException ex)
        {
            throw new LoginSampleException("Kunne ikke ændre bruger: " + ex.getMessage());
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
     */
    public static User getUser(int id) throws LoginSampleException
    {
        String user = null;
        String userPassword = null;
        String image = null;

        try
        {
            con = Connector.connection(con);

            String SQL = "SELECT * FROM `user` WHERE userid = ?;";
            ps = con.prepareStatement(SQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next())
            {
                user = rs.getString("user");
                userPassword = rs.getString("userpassword");
                image = rs.getString("image");
            }
            return new User(id, user, userPassword, image);

        } catch (SQLException ex)
        {
            throw new LoginSampleException("Kunne ikke finde bruger eller kodeord var forkert: " + ex.getMessage());
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
     */
    public static User getUser(String userName) throws LoginSampleException
    {
        int userID = 0;
        String userPassword = null;
        String image = null;

        try
        {
            con = Connector.connection(con);

            String SQL = "SELECT * FROM `user` WHERE `user` = ?;";
            ps = con.prepareStatement(SQL);
            ps.setString(1, userName);
            rs = ps.executeQuery();
            while (rs.next())
            {
                userID = rs.getInt("userid");
                userPassword = rs.getString("userpassword");
                image = rs.getString("image");
            }
            return new User(userID, userName, userPassword, image);

        } catch (SQLException ex)
        {
            throw new LoginSampleException("Kunne ikke finde bruger eller kodeord var forkert: " + ex.getMessage());
        } finally
        {
            Connector.CloseConnection(rs, ps, con);
        }
    }

    public static List<User> getUsers() throws WishSampleException, LoginSampleException
    {
        List<User> users = new ArrayList();
        try
        {
            con = Connector.connection(con);

            String SQL = "SELECT * FROM `user`;";
            ps = con.prepareStatement(SQL);
            rs = ps.executeQuery();
            while (rs.next())
            {
                users.add(new User(rs.getInt("userid"),
                        rs.getString("user"),
                        rs.getString("userpassword"),
                        rs.getString("image")
                ));
            }
            return users;

        } catch (SQLException ex)
        {
            throw new LoginSampleException("Kunne ikke skabe liste med brugere: " + ex.getMessage());
        } finally
        {
            Connector.CloseConnection(rs, ps, con);
        }
    }
}
