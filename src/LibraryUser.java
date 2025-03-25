import java.util.ArrayList;

public class LibraryUser
{
    private String name;
    private String userID;
    public String getName() {return name;}
    public String getUserID() {return userID;}
    private ArrayList<LibraryItem> borrowedItems;
    public LibraryUser(String name, String userID){
        this.name=name;
        this.userID=userID;
        borrowedItems=new ArrayList<>();
    }
    public LibraryUser(String userID) {
        this.userID = userID;
        borrowedItems=new ArrayList<>();
    }
    public boolean borrowItem(LibraryItem item){
        if (!Library.getInstance().isAvailable(item)) return false;
        Library.getInstance().getItem(item).isBorrowed=true;
        borrowedItems.add(item);
        return true;
    }
    public boolean borrowItem(String title){
        if (!Library.getInstance().isAvailable(title)) return false;
        LibraryItem item=Library.getInstance().getItem(title);
        item.isBorrowed=true;
        borrowedItems.add(item);
        return true;
    }

    public boolean returnItem(LibraryItem item)
    {
        if (!Library.getInstance().isAvailable(item)) return false;
        Library.getInstance().getItem(item).isBorrowed=false;
        return true;
    }
    public boolean returnItem(String title)
    {
        if (!Library.getInstance().isAvailable(title)) return false;
        LibraryItem item=Library.getInstance().getItem(title);
        item.isBorrowed=false;
        return true;
    }
}
