public class EBook extends LibraryItem implements Borrowable
{
    public EBook() {}
    public EBook(String title, String author, String isbn) {
        super(title, author, isbn);
    }
    public EBook(String title, String author, String isbn, long permissibleBorrowingTimeInDays) {
        super(title, author, isbn);
        this.permissibleBorrowingTimeInDays = permissibleBorrowingTimeInDays;
    }
    @Override
    public boolean borrow(LibraryItem item)
    {
        if (Library.getInstance().isAvailable(item))
        {
            Library.getInstance().getItem(item).isBorrowed = true;
            borrowingTime = System.currentTimeMillis();
            return true;
        }
        return false;
    }

    @Override
    public boolean isBorrowTimeExceeded(LibraryItem item)
    {
        if (item.isBorrowed)
            return permissibleBorrowingTimeInDays * 24 * 60 * 60 * 1000 > System.currentTimeMillis() - borrowingTime;
        return false;
    }

}
