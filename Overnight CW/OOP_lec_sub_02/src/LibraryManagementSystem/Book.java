package LibraryManagementSystem;

public class Book {
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

    public void displayItems() {         // create method for display book list

        //Traversing list
            System.out.println(bookName + "             " + authorName + "                 " + publisher + "          " + numberOfPages);

        }


    }

