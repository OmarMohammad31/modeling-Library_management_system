public interface Borrowable
{
    boolean borrow(LibraryItem item);
    boolean isBorrowTimeExceeded(LibraryItem item);
}
