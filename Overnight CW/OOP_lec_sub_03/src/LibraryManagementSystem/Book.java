package LibraryManagementSystem;

public class Book extends LibraryItem {
    private String bookName;      // declare variables
    private String authorName;
    private String publisher;
    private int numberOfPages;

    public Book(String bookName, String authorName, String publisher, int numberOfPages) {  // creating constructor for declared variables
        this.bookName = bookName;
        this.authorName = authorName;
        this.publisher = publisher;
        this.numberOfPages = numberOfPages;
    }

    public String getBookName() {       // create getters and setters
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

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

    @Override
    public void details() {
        //Traversing list
        System.out.println(bookName + "             " + authorName + "                 " + publisher + "          " + numberOfPages);

    }

    @Override
    public void add(Book book) {

    }

    @Override
    public void add(DVD dvd) {

    }
}

