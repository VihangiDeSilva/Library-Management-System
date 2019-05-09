package LibraryManagementSystem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class WestminsterLibraryManager implements LibraryManager {

    // initialize the Scanner
    Scanner sc = new Scanner(System.in);

    @Override
    public void runMenu() {     // calling methord for runMenu
        System.out.println("-----------------------------");
        System.out.println(" Welcome To Public Library ");
        System.out.println("------------------------------");

        System.out.println("Press 1 to Add a Item");
        System.out.println("Press 2 to Delete a Item");
        System.out.println("Press 3 to print the book details");
        System.out.println("Press 4 to print the DVD details");
        System.out.println("Press 5 to Borrowed an Item");
        System.out.println("Press 6 to Returned an Item");
        System.out.println("Press 7 to exit");

        Scanner c = new Scanner(System.in);
        int choice = c.nextInt();
        do {
            switch (choice) {
                case 1:
                    addItem();
                    break;
                case 2:
                    deleteItem();
                    break;
                case 3:
                    printBookDetails();
                    break;
                case 4:
                    printDVDDetails();
                    break;
                case 5:
                    returnItem();
                    break;
                case 6:
                    borrowedItem();
                    break;
                case 7:
                    System.exit(0);
                default:
                    System.out.println("Invalid input");
                    break;
            }
            c = new Scanner(System.in);
            choice = c.nextInt();
        } while (choice > 0 && choice < 7);
    }


    @Override
    public void addItem() {     // calling methord for add Item
        System.out.println("Enter Item name :");
        Scanner c = new Scanner(System.in);
        String bookName = c.nextLine();
        String authorName = c.nextLine();
        String publisher = c.nextLine();
        int numberOfPages = c.nextInt();

        Book Book = new Book(bookName,authorName,publisher,numberOfPages);
        Book.add(Book);

        String nameOfTheFilm = c.nextLine();
        String languages = c.nextLine();
        String subtitles = c.nextLine();
        String nameOfTheProducer = c.nextLine();
        String actors = c.nextLine();

        DVD DVD = new DVD(nameOfTheFilm,languages,subtitles,nameOfTheProducer,actors);
        DVD.add(DVD);
    }

    @Override
    public void deleteItem() {
    }

    @Override
    public void printBookDetails() {    // calling methord for print book details
        //Creating list of Books
        ArrayList<Book> BookList = new ArrayList<Book>();

        //Creating Books
        Book item1 = new Book("Head First Java", "                  Kathy Sierra & Bert Bates", "ABC Publishers", 2545);   // create Array List to store details of books
        item1.details();
        Book item2 = new Book("Big Java", "                         Cay S. Horstmann", "         DEF Publishers", 4545);   // create Array List to store details of books
        item2.details();
        Book item3 = new Book("Introduction To Java Programming ", "Y. Daniel Liang", "          GFR Publishers", 1245);   // create Array List to store details of books
        item3.details();
        Book item4 = new Book("Head First Design Patten", "         Eric Freeman", "             AKC Publishers", 2555);   // create Array List to store details of books
        item4.details();
        Book item5 = new Book("Thinking in Java", "                 Bruce Eckel", "              VKC Publishers", 2695);   // create Array List to store details of books
        item5.details();

        boolean go = true;
        while (go) {

            System.out.print("\nDo you want to View the List Of DVDs ? (0 - No / 1 - Yes) : ");   // asking from user wants view the list of DVDs

            int goValue = sc.nextInt();

            if (goValue == 0) {
                go = false;
                System.out.println("Thank You For Join With Us!!");
                System.exit(0);
            } else if (goValue == 1) {
                go = true;
                printDVDDetails();
            }
        }
    }


    @Override
    public void printDVDDetails() {     // calling methord for print DVD details
        System.out.println("\n------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Film                     Languages               Subtitles                Producer              Actors");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------");

        //Creating list of DVDs
        ArrayList<DVD> DVDList = new ArrayList<DVD>();

        DVD dvd1 = new DVD("The Nun", "      English", "English/Korean", " Corin Hardy", "     Demián Bichir,Taissa Farmi,Jonas Bloquet,Bonnie Aarons"); // create Array List to store details of DVDs
        dvd1.details();
        DVD dvd2 = new DVD("Baaghi 2", "     Hindi", "  English/Sinhala", "Sajid Nadiadwala", "Tiger Shroff, Ronny Singh,Neha Salgaonkar ,Randeep Hooda"); // create Array List to store details of DVDs
        dvd2.details();
        DVD dvd3 = new DVD("Annabelle", "    English", "English/Korean", " James Wan", "       Annabelle Wallis,Mia,Ward Horton,Kerry O'Malley"); // create Array List to store details of DVDs
        dvd3.details();
        DVD dvd4 = new DVD("Jurassic Park", "English", "English/Korean", " Kathleen Kennedy", "Sam Neill,Jeff Goldblum, Laura Dern,Richard Attenborough"); // create Array List to store details of DVDs
        dvd4.details();
        DVD dvd5 = new DVD("Venom", "        English", "English/Korean", " Avi Arad", "        Tom Hardy, Michelle Williams, Anne Weying,Scott Haze"); // create Array List to store details of DVDs
        dvd5.details();

        boolean goo = true;
        while (goo) {

            System.out.print("\nDo you want to View the List Of Boos ? (0 - No / 1 - Yes) : ");   // asking from user wants view the list of Books

            int goValue = sc.nextInt();

            if (goValue == 0) {
                goo = false;
                System.out.println("Thank You For Join With Us!!");
                System.exit(0);
            } else if (goValue == 1) {
                goo = true;
                printBookDetails();
                }
        }
    }

    @Override
        public void returnItem() {      // calling methord for return Item
        System.out.println("Enter Student Id & Book Id :");
        Scanner c = new Scanner(System.in);
        String bookName = c.nextLine();
        /*int bookId = c.nextInt();
        List<Book> bd = hm.get(id);
        for (Book b : bd) {
            if (b.Book() == bookId) {
                Date issueDate = b.getIssueDate();
                Date todayDate = new Date();

                long diff = todayDate.getTime() - issueDate.getTime();

                long diffDays = diff / (24 * 60 * 60 * 1000);

                if (diffDays > 10) {
                    int fine = (int) (diffDays - 10);
                    fine = fine * 10;
                    System.out.println("Total Fine " + fine + " Rs.");
                }
            }*/
       // }
    }
        @Override
        public void borrowedItem(){

        }
                    }













