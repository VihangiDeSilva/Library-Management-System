package dto;

public class Book extends LibraryItem{

       // declare variables
    public String authorName;
    public String publisher;
    public int numberOfPages;

    //create constructor
    public Book(int isbn, String itemName, Reader reader, String authorName, String publisher, int numberOfPages) {
        super(isbn, itemName, reader);
        this.authorName = authorName;
        this.publisher = publisher;
        this.numberOfPages = numberOfPages;
    }


    //getters and setters
    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }















}
