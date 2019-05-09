package LibraryManagementSystem;

import java.util.Scanner;

public class Reader  {

    // initialize the Scanner
    Scanner sc = new Scanner(System.in);

    private int ID;                 // declare variables
    private String name;
    private int mobileNO;
    private String emailAddress;

    public Reader() {       // creating constructor for declared variables
        this.ID = ID;
        this.name = name;
        this.mobileNO = mobileNO;
        this.emailAddress = emailAddress;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMobileNO() {
        return mobileNO;
    }

    public void setMobileNO(int mobileNO) {
        this.mobileNO = mobileNO;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void details(){  // calling methord for get user details
        System.out.println("-----------------------------");
        System.out.println(" Welcome To Public Library ");
        System.out.println("------------------------------");
        System.out.print("Enter Your Name :");
        name = sc.next();
        System.out.print("Enter Your ID :");
        ID = sc.nextInt();
        System.out.print("Enter Your Mobile Number :");
        mobileNO = sc.nextInt();
        System.out.print("Enter Your Email Address :");
        emailAddress = sc.next();
        System.out.println("\n Welcome!! "+name+ " Select Book From Here :");
    }


      }

