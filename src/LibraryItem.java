public abstract class LibraryItem
{
    protected String title;
    protected String author;
    protected String ISBN;
    protected boolean isBorrowed; //false by default in java
    protected long borrowingTime;
    protected long permissibleBorrowingTimeInDays;
    public LibraryItem() {}
    public LibraryItem(String title, String author, String ISBN) {
        this.title=title;
        this.author=author;
        this.ISBN=ISBN;
    }
    public void setTitle(String title){this.title=title;}
    public void setAuthor(String author){this.author=author;}
    public void setISBN(String ISBN){this.ISBN=ISBN;}
    public String getTitle(){return title;}
    public String getAuthor(){return author;}
    public String getISBN(){return ISBN;}
    public boolean isBorrowed(){return isBorrowed;}
    public boolean isAvailable(LibraryItem item){
        return Library.getInstance().isAvailable(item);
    }
    public boolean returnItem(LibraryItem item){
        LibraryItem myItem = Library.getInstance().getItem(item);
        if (myItem == null) return false;
        else Library.getInstance().getItem(item).isBorrowed=false;
        return true;
    }
    abstract public boolean borrow(LibraryItem item);
}
