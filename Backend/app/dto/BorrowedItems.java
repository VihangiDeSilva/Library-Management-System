package dto;

public class BorrowedItems {

    private Reader reader_name;
    private LibraryItem libraryItem;
    private DateTime borrowedDate;

    public BorrowedItems(Reader reader_name, LibraryItem libraryItem, DateTime borrowedDate) {
        this.reader_name = reader_name;
        this.libraryItem = libraryItem;
        this.borrowedDate = borrowedDate;
    }

    public Reader getReader_name() {
        return reader_name;
    }

    public void setReader_name(Reader reader_name) {
        this.reader_name = reader_name;
    }

    public LibraryItem getLibraryItem() {
        return libraryItem;
    }

    public void setLibraryItem(LibraryItem libraryItem) {
        this.libraryItem = libraryItem;
    }

    public DateTime getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(DateTime borrowedDate) {
        this.borrowedDate = borrowedDate;
    }
}
