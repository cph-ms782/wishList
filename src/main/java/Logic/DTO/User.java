package Logic.DTO;

/**
 *
 * @author martin
 */
public class User
{

    private int userID;
    private String userName;
    private String password;
    private String img;

    
    public User(String userName, String password, String img)
    {
        this.userID = 0;
        this.userName = userName;
        this.password = password;
        this.img = img;
    }

    public User(int userID, String userName, String password, String img)
    {
        this.userID = userID;
        this.userName = userName;
        this.password = password;
        this.img = img;
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
        return userName;
    }

    public void setUser(String userName)
    {
        this.userName = userName;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getImg()
    {
        return img;
    }

    public void setImg(String img)
    {
        this.img = img;
    }

    @Override
    public String toString()
    {
        return "User{" + "userID=" + userID + ", userName=" + userName + ", password=" + password + ", img=" + img + '}';
    }
    
    
    
}
