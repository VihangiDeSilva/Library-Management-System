package LibraryManagementSystem;

import java.util.Date;

public abstract class LibraryItem {

    int ISBN;               // declare variables
    String title;
    String sector;
    Date dateOfPublished;
    Date dateOfBorrowed;
    String currentReader;


    public abstract void details();

    public abstract void add(Book book);

    public abstract void add(DVD dvd);
}
