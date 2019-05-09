package services;

import dto.*;

import java.util.List;

public interface LibraryManager {



    List<Book> displayBooks();  //prompt book list
    void addBooks(Book book); // add book


    List<DVD> displayDVD();  //prompt DVD list
    void addDVD(DVD dvd); // add book

    int deleteItem(int _isbn);

    boolean BorrowItem(LibraryItem libraryItem, Reader reader, DateTime borrowedDate);

    //register a new members
    void addMembers(Reader reader);

    boolean returnItem(LibraryItem libraryItem, Reader reader);




}
