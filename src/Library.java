import java.util.ArrayList;

public class Library
{
    private Library(){}
    // utilizing eager singleton design pattern to allow only 1 library object in our program to prevent multi libraries at a time
    private static final Library instance = new Library();
    private final ArrayList<LibraryItem> items = new ArrayList<>();//final keyword to prevent reassigning our ArrayList of Library items which can cause data loss
    public static Library getInstance(){return instance;}
    public boolean isAvailable(LibraryItem myItem){
        for (LibraryItem item: items) {
            if (item == myItem) return !myItem.isBorrowed();
        }
        return false;
    }
    public ArrayList<LibraryItem> listAvailableItems(){
        ArrayList<LibraryItem> availableItems = new ArrayList<>();
        for(LibraryItem item: items){
            if (!item.isBorrowed()) availableItems.add(item);
        }
        return availableItems;
    }
    public void addItem(LibraryItem item){
        items.add(item);
    }
    public LibraryItem searchItem(LibraryItem item) {
        for (LibraryItem myItem: items){
            if (myItem==item) return item;
        }
        return null;
    }
}
