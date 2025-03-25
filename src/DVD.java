public class DVD extends LibraryItem implements Borrowable
{
    private long borrowingTime;
    private long permissibleBorrowingTimeInDays;
    @Override
    public boolean borrow(LibraryItem item) {
        if (Library.getInstance().isAvailable(item)){
            Library.getInstance().getItem(item).isBorrowed=true;
            borrowingTime = System.currentTimeMillis();
            return true;
        }
        return false;
    }
    @Override
    public boolean isBorrowTimeExceeded(LibraryItem item)
    {
        if (item.isBorrowed) return permissibleBorrowingTimeInDays*24*60*60*1000 >System.currentTimeMillis()-borrowingTime;
        return false;
    }

}
