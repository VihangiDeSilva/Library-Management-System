package LibraryManagementSystem;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTime {
    private Date itemBorrowedDate;  // declare variable
    private Time itemBorrowedTime;

    public DateTime() {     // creating constructor for declared variables
        this.itemBorrowedDate = itemBorrowedDate;
        this.itemBorrowedTime = itemBorrowedTime;
    }

    public Date getItemBorrowedDate() {     // create getters and setters
        return itemBorrowedDate;
    }

    public void setItemBorrowedDate(Date itemBorrowedDate) {
        this.itemBorrowedDate = itemBorrowedDate;
    }

    public Time getItemBorrowedTime() {
        return itemBorrowedTime;
    }

    public void setItemBorrowedTime(Time itemBorrowedTime) {
        this.itemBorrowedTime = itemBorrowedTime;
    }

    public void dateTime(){
        Date dNow = new Date( );
        SimpleDateFormat ft = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss ");
        System.out.println("\nItem Get Date and Time: " + ft.format(dNow));
        }

    }

