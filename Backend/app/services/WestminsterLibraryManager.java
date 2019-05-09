
package services;

import dto.*;

import java.util.ArrayList;
import java.util.List;

public class WestminsterLibraryManager implements LibraryManager {

    //Creating Array list of Books
     List<Book> bookArrayList= new ArrayList<Book>();
    List<Reader> readerArrayList = new ArrayList<>();

    //Creating Array list of DVD
    List<DVD> dvdArrayList = new ArrayList<DVD>();
    List<BorrowedItems> borrowedItems = new ArrayList<>();

    @Override
    public List<Book> displayBooks() {      // calling method for prompt book details
        return bookArrayList;

    }
   /* public List<LibraryItem> displayBooks1(){
        return book_list;
    }*/

    @Override
    public void addBooks(Book book) {    // calling method for add book
        bookArrayList.add(book);
        //book_list.add(book);

    }



    @Override
    public List<DVD> displayDVD() {       // calling method for prompt DVD details
        return dvdArrayList;


    }

    @Override
    public void addDVD(DVD dvd) {   // calling method for add DVD
        dvdArrayList.add(dvd);

    }

    // calling method for delete item
    int item_delete_status;
    @Override
    public int deleteItem(int _isbn) {
        item_delete_status =0;
        for (int i=0; i< dvdArrayList.size() ;i++){
            if (dvdArrayList.get(i).getIsbn()==_isbn){
                dvdArrayList.remove(i);
                item_delete_status=2;
            }
        }
        if (item_delete_status==2){

        }else {
            for (int j=0; j< bookArrayList.size() ;j++){
                if (bookArrayList.get(j).getIsbn()==_isbn){
                    bookArrayList.remove(j);
                    item_delete_status=1;
                }else {
                    item_delete_status=0;
                }
            }
        }

        return item_delete_status;

    }
    public int deleteBook(int isbn){
        item_delete_status=0;
        for (int i=0; i< bookArrayList.size() ;i++){
            if (bookArrayList.get(i).getIsbn()==isbn){
                bookArrayList.remove(i);
                item_delete_status=1;
            }else {
                item_delete_status=0;
            }
        }
        return item_delete_status;
    }

   public int deleteDvd(int isbn){
        item_delete_status=0;
        for (int i=0; i< dvdArrayList.size() ;i++){
            if (dvdArrayList.get(i).getIsbn()==isbn){
                dvdArrayList.remove(i);
                item_delete_status=2;
            }
        }
        return item_delete_status;
    }


    //get size of book list
    public int book_list_size(){
        return bookArrayList.size();
    }
    //get size of dvd list
    public int dvd_list_size(){
        return dvdArrayList.size();
    }



    boolean validity;
    public boolean isbnValidity(int _isbn){
        validity=false;//
        for (int i=0; i< bookArrayList.size() ;i++){

            if(bookArrayList.get(i).getIsbn()==_isbn){

                //Book book= (Book) book_list.get();
                validity=true;

            }
        }if (validity){

        }else {
            for (int j=0; j< dvdArrayList.size() ;j++){
                if (dvdArrayList.get(j).getIsbn()==_isbn){
                    validity=true;
                }else {
                    validity=false;
                }
            }
        }

        return validity;
    }
    //check the book already borrowed or not
    Boolean checkBSetStatus;
    public boolean checkBSet(BorrowedItems requestItem){
        checkBSetStatus=false;
        for (int i=0; i< borrowedItems.size() ;i++){
            if (borrowedItems.equals(requestItem)){
                checkBSetStatus=true;

            }else {
                checkBSetStatus=false;
            }
        }
        return checkBSetStatus;
    }



    //check the reader is already registered member or not
    boolean reader_validity;
    public boolean checkReader(int readerId){
        reader_validity=false;
        for (int i=0; i< readerArrayList.size() ;i++){
            if (readerArrayList.get(i).getReaderID()==readerId){
                reader_validity= true;
            }else {
                reader_validity= false;
            }
        }
        return reader_validity;
    }

    //get reader object
    Reader reader;
    public Reader getReader(int readerId){
        reader=null;

        for (int i=0; i< readerArrayList.size() ;i++){
            if (readerArrayList.get(i).getReaderID()==readerId){
                reader=readerArrayList.get(i);
            }
        }
        return reader;
    }

    //search a library item
    private LibraryItem libraryItem;
    public LibraryItem libraryItem(int _isbn){

        for (int i=0; i< bookArrayList.size() ;i++){


            if(bookArrayList.get(i).getIsbn()==_isbn){

                libraryItem=bookArrayList.get(i);

            }
        }

        for (int i=0; i< dvdArrayList.size() ;i++){
            if (dvdArrayList.get(i).getIsbn()==_isbn){
                libraryItem=dvdArrayList.get(i);
            }
        }
        return  libraryItem;
    }


    //borrow item method
    private boolean borrowingStatus;
    @Override
    public boolean BorrowItem(LibraryItem libraryItem, Reader reader, DateTime borrowedDate){
        borrowingStatus=false;


        BorrowedItems requestItem=new BorrowedItems(reader,libraryItem,borrowedDate);


        if (checkBSet(requestItem)==false){
            libraryItem.setBorrowedDate(borrowedDate);
            libraryItem.setCurrentReader(reader);
            borrowedItems.add(requestItem);
            borrowingStatus=true;
        }else {
            borrowingStatus=false;
        }

        return borrowingStatus;
    }


    public List<BorrowedItems> getBorrowedItems(){
        return borrowedItems;
    }

    public void setReaderArrayList(Reader readerArrayList) {
        this.readerArrayList.add(readerArrayList);
        System.out.println(readerArrayList);
    }

    //register a new members
    @Override
    public void addMembers(Reader reader){
        readerArrayList.add(reader);
    }

    private boolean returnItemStatus;
    @Override
    public boolean returnItem(LibraryItem libraryItem,Reader reader){
        returnItemStatus=false;
        DateTime borrowedDate= libraryItem.getBorrowedDate();

        BorrowedItems borrowedItems=new BorrowedItems(reader,libraryItem,borrowedDate);

        libraryItem.setCurrentReader(null);//

        if (checkBSet(borrowedItems)){
            this.borrowedItems.remove(borrowedItems);
            libraryItem.setBorrowedDate(null);
            libraryItem.setCurrentReader(null);
            returnItemStatus=true;
        }else {
            returnItemStatus=false;
        }
        return returnItemStatus;
    }
}
