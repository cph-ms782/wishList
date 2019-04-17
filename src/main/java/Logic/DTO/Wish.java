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

    public Wish(String wishText)
    {
        this.wishText = wishText;
        this.giver = null;
        this.notes = null;
    }

    public Wish(String wishText, String giver, String notes)
    {
        this.wishText = wishText;
        this.giver = giver;
        this.notes = notes;
    }

    public Wish(int wishID, String wishText, String giver, String notes)
    {
        this.wishID = wishID;
        this.wishText = wishText;
        this.giver = giver;
        this.notes = notes;
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

    @Override
    public String toString()
    {
        return "Wish{" + "wishID=" + wishID + ", wishText=" + wishText + ", giver=" + giver + ", notes=" + notes + '}';
    }
    
}
