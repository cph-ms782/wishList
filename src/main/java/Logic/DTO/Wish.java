package Logic.DTO;

/**
 *
 * @author martin
 */
public class Wish
{
    private int wishID;
    private String wishText;
    private String giver;
    private String notes;
    private String link;
    private int userID;

    public Wish(String wishText, String link, int userID)
    {
        this.wishText = wishText;
        this.giver = null;
        this.notes = null;
        this.link = link;
        this.userID = userID;
    }

    public Wish(String wishText, String giver, String notes, String link, int userID)
    {
        this.wishText = wishText;
        this.giver = giver;
        this.notes = notes;
        this.link = link;
        this.userID = userID;
    }

    public Wish(int wishID, String wishText, String giver, String notes, String link, int userID)
    {
        this.wishID = wishID;
        this.wishText = wishText;
        this.giver = giver;
        this.notes = notes;
        this.link = link;
        this.userID = userID;
    }
    
    public int getWishID()
    {
        return wishID;
    }

    public void setWishID(int wishID)
    {
        this.wishID = wishID;
    }

    public String getWishText()
    {
        return wishText;
    }

    public void setWishText(String wishText)
    {
        this.wishText = wishText;
    }

    public String getGiver()
    {
        return giver;
    }

    public void setGiver(String giver)
    {
        this.giver = giver;
    }

    public String getNotes()
    {
        return notes;
    }

    public void setNotes(String notes)
    {
        this.notes = notes;
    }

    public String getLink()
    {
        return link;
    }

    public void setLink(String link)
    {
        this.link = link;
    }

    public int getUserID()
    {
        return userID;
    }

    public void setUserID(int userID)
    {
        this.userID = userID;
    }

    @Override
    public String toString()
    {
        return "Wish{" + "wishID=" + wishID + ", wishText=" + wishText + ", giver=" + giver + ", notes=" + notes + ", link=" + link + ", userID=" + userID + '}';
    }

    
    
    
}
