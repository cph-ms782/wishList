package Logic.DTO;

/**
 *
 * @author martin
 */
public class User
{
    private int userID;
    private String user;
    private String userPassword;
    private String image;

    public User(String user, String userPassword, String image)
    {
        this.user = user;
        this.userPassword = userPassword;
        this.image = image;
    }

    public User(int userID, String user, String userPassword, String image)
    {
        this.userID = userID;
        this.user = user;
        this.userPassword = userPassword;
        this.image = image;
    }

    public int getUserID()
    {
        return userID;
    }

    public void setUserID(int userID)
    {
        this.userID = userID;
    }

    public String getUser()
    {
        return user;
    }

    public void setUser(String user)
    {
        this.user = user;
    }

    public String getUserPassword()
    {
        return userPassword;
    }

    public void setUserPassword(String userPassword)
    {
        this.userPassword = userPassword;
    }

    public String getImage()
    {
        return image;
    }

    public void setImage(String image)
    {
        this.image = image;
    }

    @Override
    public String toString()
    {
        return "User{" + "userID=" + userID + ", user=" + user + ", userPassword=" + userPassword + ", image=" + image + '}';
    }

    
}
