import java.util.ArrayList;
import java.util.Objects;

public class Library
{
    private Library(){}
    // utilizing eager singleton design pattern to allow only 1 library object in our program to prevent multi libraries at a time
    private static final Library instance = new Library();
    private final ArrayList<LibraryUser> users = new ArrayList<>();
    private final ArrayList<LibraryItem> items = new ArrayList<>();//final keyword to prevent reassigning our ArrayList of Library items which can cause data loss
    public static Library getInstance(){return instance;}
    public boolean isAvailable(LibraryItem myItem){
        for (LibraryItem item: items) {
            if (item == myItem) return !myItem.isBorrowed();
        }
        return false;
    }
    public boolean isBorrowed(String title){
        for (LibraryItem item: items) {
            if (item.getTitle().equals(title)) return item.isBorrowed();
        }
        return false;
    }
    public boolean isExistingItem(String title){
        for (LibraryItem item: items) {
            if (item.getTitle().equals(title)) return true;
        }
        return false;
    }
    public boolean isAvailable(String title){
        for (LibraryItem item: items) {
            if (item.getTitle().equals(title)) return !item.isBorrowed();
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

    public void addUser(LibraryUser user) {users.add(user);}
    public void addUser(String name, String userID){users.add(new LibraryUser(name, userID));}
    public void addUser(String userID){users.add(new LibraryUser(userID));}
    public LibraryItem getItem(LibraryItem item) {
        for (LibraryItem myItem: items){
            if (myItem==item) return item;
        }
        return null;
    }
    public LibraryUser getUser(String userID) {
        for (LibraryUser user: users){
            if (Objects.equals(user.getUserID(), userID)) return user;
        }
        return null;
    }
    public LibraryItem getItem(String title){
        for (LibraryItem item: items){
            if (item.getTitle().equals(title)) return item;
        }
        return null;
    }
    public LibraryItem getItem(int index) {
        if (index<0 || index>=items.size()) return null;
        return items.get(index);
    }

    public int size() {
        return items.size();
    }
}
