package dto;

public abstract class LibraryItem {

    private int isbn;
    private String itemName;
    private Reader reader;

    private Reader currentReader;
    private DateTime borrowedDate;
    public LibraryItem(int isbn, String itemName, Reader reader) {
        this.isbn = isbn;
        this.itemName = itemName;
        this.reader = reader;
    }

    public Reader getCurrentReader() {
        return currentReader;
    }

    public void setCurrentReader(Reader currentReader) {
        this.currentReader = currentReader;
    }

    public DateTime getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(DateTime borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }
}
