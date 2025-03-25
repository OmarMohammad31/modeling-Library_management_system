public class ReferenceBook extends LibraryItem
{
    public ReferenceBook(){}
    public ReferenceBook(String title, String author, String isbn){
        super(title,author,isbn);
    }

    //can't borrow a reference book
    // I have to implement it as the assignment says borrow() has to be concrete in LibraryItem class
    @Override
    public boolean borrow(LibraryItem item) {return false;}

}
