public class PhysicalBook extends LibraryItem implements Borrowable
{
    private long borrowingTime;
    private long permissibleBorrowingTime;
    @Override
    public boolean borrow(LibraryItem item) {
        if (Library.getInstance().isAvailable(item)){
            isBorrowed=true;
            borrowingTime = System.currentTimeMillis();
            return true;
        }
        return false;
    }
    @Override
    public boolean isBorrowTimeExceeded(LibraryItem item)
    {
        return permissibleBorrowingTime<=System.currentTimeMillis()-borrowingTime;
    }

}
