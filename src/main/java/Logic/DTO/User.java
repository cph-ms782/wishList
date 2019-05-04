package Logic.DTO;

/**
 *
 * @author martin
 */
public class User
{
    private int userID;
    private String userName;
    private String userPassword;
    private String image;

    public User(String userName, String userPassword, String image)
    {
        this.userName = userName;
        this.userPassword = userPassword;
        this.image = image;
    }

    public User(int userID, String userName, String userPassword, String image)
    {
        this.userID = userID;
        this.userName = userName;
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

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
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
        return "User{" + "userID=" + userID + ", userName=" + userName + ", userPassword=" + userPassword + ", image=" + image + '}';
    }

    
}
