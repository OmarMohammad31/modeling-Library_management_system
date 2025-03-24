import java.util.ArrayList;

public class LibraryUser
{
    private String name;
    private String userID;
    private ArrayList<LibraryItem> borrowedItems;
    public boolean borrowItem(LibraryItem item){
        if (!Library.getInstance().isAvailable(item)) return false;
        Library.getInstance().getItem(item).isBorrowed=true;
        return true;
    }

    public boolean returnItem(LibraryItem item)
    {
        if (!Library.getInstance().isAvailable(item)) return false;
        Library.getInstance().getItem(item).isBorrowed=false;
        return true;
    }
}
