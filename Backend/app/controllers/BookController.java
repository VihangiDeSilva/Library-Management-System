package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonNode;
import dto.*;
import play.mvc.Controller;
import play.mvc.*;

import java.util.List;
import play.libs.Json;
import services.WestminsterLibraryManager;


public class BookController extends Controller {

    //crete object
    WestminsterLibraryManager wlManager = new WestminsterLibraryManager();

    //Method to prompt list of books
    public Result displayBook() {

        List<Book> books = wlManager.displayBooks();
        JsonNode jsonNode = play.libs.Json.toJson(books);
        return ok(jsonNode).as("application/json");
    }

    //Method to Add book
    public Result addBooks() {

        try {
            JsonNode json = Json.parse(request().body().asText());
            int ISBN = Integer.parseInt(json.get("isbn").asText());
            String bookName = json.get("bname").asText();
            String publisher = json.get("publisher").asText();
            String authorName = json.get("author").asText();
            int numberOfPages = Integer.parseInt(json.get("pages").asText());

            Book book = new Book(ISBN, bookName,null, authorName, publisher, numberOfPages);

            wlManager.addBooks(book);
            return ok(Json.toJson("successfully added to the system.")).as("application/json");
        }catch(Exception e){
            return ok(Json.toJson(String.valueOf(e))).as("application/json");
        }

    }

    //borrow a item
    public Result borrowItem(){

        //validations
        try{
            JsonNode jn = Json.parse(request().body().asText());

           // wlManager.setReaderArrayList(reader);
           // System.out.println(reader);
            int _isbn=Integer.parseInt(jn.get("_isbn").asText());
            int readerId=Integer.parseInt(jn.get("reader_id").asText());

            int b_date=Integer.parseInt(jn.get("b_date").asText());
            int b_month=Integer.parseInt(jn.get("b_month").asText());
            int b_year=Integer.parseInt(jn.get("b_year").asText());
            int b_hours=Integer.parseInt(jn.get("b_hours").asText());
            int b_mins=Integer.parseInt(jn.get("b_mins").asText());

            DateTime borrowedDate=new DateTime(b_date,b_month,b_year,b_hours,b_mins);
            boolean isbn_validity= wlManager.isbnValidity(_isbn);
            boolean readerValidity=wlManager.checkReader(readerId);

            String borrowMessage;
            if (isbn_validity==true && readerValidity){

                if (wlManager.BorrowItem(wlManager.libraryItem(_isbn),wlManager.getReader(readerId),
                        borrowedDate)){
                    borrowMessage="Borrowing success";
                }else{
                    borrowMessage="Item not available";
                }

            }else {
                borrowMessage="ISBN or Reader Id is incorrect.";
            }

            return ok(Json.toJson(borrowMessage)).as("application/json");
        }catch (Exception e){
            // return ok(Json.toJson(String.valueOf(e))).as("application/json");
            return ok(Json.toJson("System Error")).as("application/json");
        }


    }

    public Result getBorowedItems(){
        List<BorrowedItems> borrowedItems=wlManager.getBorrowedItems();
        JsonNode jsonNode = play.libs.Json.toJson(borrowedItems);
        return ok(jsonNode).as("application/json");
    }

    //add readers to system
    public Result addReaders(){

        //validations
        try{
            JsonNode json = Json.parse(request().body().asText());
            int readerId=Integer.parseInt(json.get("readerId").asText());
            int readerMobileNo=Integer.parseInt(json.get("readerMobileNo").asText());
            String readerName= json.get("readerName").asText();
            String readerEmail= json.get("readerEmail").asText();

            Reader reader=new Reader(readerId,readerName,readerEmail,readerMobileNo);

            wlManager.addMembers(reader);
            return ok(Json.toJson("Member registration success")).as("application/json");
        }catch (Exception e){
            return ok(Json.toJson("Invalid inputs. Fill all fields correctly")).as("application/json");
        }


    }



    //method to return a item
    private String returnMessage;
    public Result returnItem(){

        //validations
        try{
            JsonNode json = Json.parse(request().body().asText());
            int r_isbn=Integer.parseInt(json.get("r_isbn").asText());
            int reader_id=Integer.parseInt(json.get("reader_id").asText());

            int r_date=Integer.parseInt(json.get("r_date").asText());
            int r_month=Integer.parseInt(json.get("r_month").asText());
            int r_year=Integer.parseInt(json.get("r_year").asText());
            int r_hours=Integer.parseInt(json.get("r_hours").asText());
            int r_mins=Integer.parseInt(json.get("r_mins").asText());

            //check the isbn and reader id is valid
            if (wlManager.isbnValidity(r_isbn)&&wlManager.checkReader(reader_id)){

                if (!wlManager.returnItem(wlManager.libraryItem(r_isbn),
                        wlManager.getReader(reader_id))){
                    returnMessage="Item Returned Successfully.";
                }else{

                    DateTime returnedDate=new DateTime(r_date,r_month,r_year,r_hours,r_mins);
//                    double fine=wlManager.calculateFine(r_isbn,wlManager.libraryItem(r_isbn),
//                            returnedDate);
//
//                    if (fine<=0.0){
//                        returnMessage="No fine";
//                    }else {
//                        returnMessage="Total fine : "+fine;
//                    }
                }

            }else {
                returnMessage="ISBN or Member ID not valid";
            }

            return ok(Json.toJson(returnMessage)).as("application/json");
        }catch (Exception e){
            return ok(Json.toJson("Invalid inputs. Fill all fields correctly")).as("application/json");
        }

    }


}

